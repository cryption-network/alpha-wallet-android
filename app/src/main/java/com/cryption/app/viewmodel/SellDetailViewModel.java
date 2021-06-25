package com.cryption.app.viewmodel;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import android.content.Context;

import com.cryption.app.entity.CryptoFunctions;
import com.cryption.app.entity.NetworkInfo;
import com.cryption.app.entity.Operation;
import com.cryption.app.entity.SignAuthenticationCallback;
import com.cryption.app.entity.cryptokeys.SignatureFromKey;
import com.cryption.app.entity.tokens.Token;
import com.cryption.app.entity.Wallet;
import com.cryption.app.entity.tokens.TokenTicker;
import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepository;
import com.cryption.app.router.SellDetailRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.MarketQueueService;
import com.cryption.app.ui.SellDetailActivity;
import com.cryption.app.util.Utils;
import com.cryption.token.entity.SalesOrderMalformed;
import com.cryption.token.entity.SignableBytes;
import com.cryption.token.tools.ParseMagicLink;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by James on 21/02/2018.
 */

public class SellDetailViewModel extends BaseViewModel {
    private final MutableLiveData<Wallet> defaultWallet = new MutableLiveData<>();
    private final MutableLiveData<Double> ethereumPrice = new MutableLiveData<>();
    private final MutableLiveData<String> universalLinkReady = new MutableLiveData<>();

    private Token token;
    private ParseMagicLink parser;

    private final FindDefaultNetworkInteract findDefaultNetworkInteract;
    private final GenericWalletInteract genericWalletInteract;
    private final MarketQueueService marketQueueService;
    private final CreateTransactionInteract createTransactionInteract;
    private final SellDetailRouter sellDetailRouter;
    private final KeyService keyService;
    private final AssetDefinitionService assetDefinitionService;

    private byte[] linkMessage;

    SellDetailViewModel(FindDefaultNetworkInteract findDefaultNetworkInteract,
                        GenericWalletInteract genericWalletInteract,
                        MarketQueueService marketQueueService,
                        CreateTransactionInteract createTransactionInteract,
                        SellDetailRouter sellDetailRouter,
                        KeyService keyService,
                        AssetDefinitionService assetDefinitionService) {
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.genericWalletInteract = genericWalletInteract;
        this.marketQueueService = marketQueueService;
        this.createTransactionInteract = createTransactionInteract;
        this.sellDetailRouter = sellDetailRouter;
        this.keyService = keyService;
        this.assetDefinitionService = assetDefinitionService;
    }

    private void initParser()
    {
        if (parser == null)
        {
            parser = new ParseMagicLink(new CryptoFunctions(), EthereumNetworkRepository.extraChains());
        }
    }

    public LiveData<Wallet> defaultWallet() {
        return defaultWallet;
    }
    public LiveData<Double> ethereumPrice() { return ethereumPrice; }
    public LiveData<String> universalLinkReady() { return universalLinkReady; }

    public String getSymbol()
    {
        return findDefaultNetworkInteract.getNetworkInfo(token.tokenInfo.chainId).symbol;
    }

    public NetworkInfo getNetwork()
    {
        return findDefaultNetworkInteract.getNetworkInfo(token.tokenInfo.chainId);
    }

    public void prepare(Token token, Wallet wallet) {
        this.token = token;
        this.defaultWallet.setValue(wallet);
        //now get the ticker
        /*disposable = findDefaultNetworkInteract
                .getTicker(token)
                .subscribe(this::onTicker, this::onError);*/
    }

    private void onTicker(TokenTicker ticker)
    {
        if (ticker != null && ticker.updateTime != 0)
        {
            ethereumPrice.postValue(Double.parseDouble(ticker.price));
        }
    }

    public void generateUniversalLink(List<BigInteger> ticketSendIndexList, String contractAddress, BigInteger price, long expiry)
    {
        initParser();
        if (ticketSendIndexList == null || ticketSendIndexList.size() == 0) return; //TODO: Display error message

        int[] indexList = new int[ticketSendIndexList.size()];
        for (int i = 0; i < ticketSendIndexList.size(); i++) indexList[i] = ticketSendIndexList.get(i).intValue();

        SignableBytes tradeBytes = new SignableBytes(parser.getTradeBytes(indexList, contractAddress, price, expiry));
        try {
            linkMessage = ParseMagicLink.generateLeadingLinkBytes(indexList, contractAddress, price, expiry);
        } catch (SalesOrderMalformed e) {
            //TODO: Display appropriate error to user
        }

        //sign this link
        disposable = createTransactionInteract
                .sign(defaultWallet().getValue(), tradeBytes, token.tokenInfo.chainId)
                .subscribe(this::gotSignature, this::onError);
    }

    public void openUniversalLinkSetExpiry(Context context, List<BigInteger> selection, double price)
    {
        sellDetailRouter.openUniversalLink(context, token, Utils.bigIntListToString(selection, false), defaultWallet.getValue(), SellDetailActivity.SET_EXPIRY, price);
    }

    private void gotSignature(SignatureFromKey signature)
    {
        initParser();
        String universalLink = parser.completeUniversalLink(token.tokenInfo.chainId, linkMessage, signature.signature);
        //Now open the share icon
        universalLinkReady.postValue(universalLink);
    }

    public AssetDefinitionService getAssetDefinitionService()
    {
        return assetDefinitionService;
    }

    public void getAuthorisation(Activity activity, SignAuthenticationCallback callback)
    {
        if (defaultWallet.getValue() != null)
        {
            keyService.getAuthenticationForSignature(defaultWallet.getValue(), activity, callback);
        }
    }

    public void resetSignDialog()
    {
        keyService.resetSigningDialog();
    }

    public void completeAuthentication(Operation signData)
    {
        keyService.completeAuthentication(signData);
    }

    public void failedAuthentication(Operation signData)
    {
        keyService.failedAuthentication(signData);
    }
}
