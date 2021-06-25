package com.cryption.app.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.cryption.app.entity.Wallet;
import com.cryption.app.entity.tokens.Token;
import com.cryption.app.router.RedeemSignatureDisplayRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.ui.widget.entity.TicketRangeParcel;
import com.cryption.token.entity.TicketRange;

/**
 * Created by James on 27/02/2018.
 */

public class RedeemAssetSelectViewModel extends BaseViewModel {
    private final RedeemSignatureDisplayRouter redeemSignatureDisplayRouter;
    private final AssetDefinitionService assetDefinitionService;

    private final MutableLiveData<Wallet> defaultWallet = new MutableLiveData<>();

    public RedeemAssetSelectViewModel(
            RedeemSignatureDisplayRouter redeemSignatureDisplayRouter,
            AssetDefinitionService assetDefinitionService)
    {
        this.redeemSignatureDisplayRouter = redeemSignatureDisplayRouter;
        this.assetDefinitionService = assetDefinitionService;
    }

    public void showRedeemSignature(Context ctx, TicketRange range, Token token)
    {
        TicketRangeParcel parcel = new TicketRangeParcel(range);
        redeemSignatureDisplayRouter.open(ctx, defaultWallet.getValue(), token, parcel);
    }

    public AssetDefinitionService getAssetDefinitionService()
    {
        return assetDefinitionService;
    }
}
