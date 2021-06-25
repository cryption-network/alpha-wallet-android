package com.cryption.app.repository;

import com.cryption.app.entity.ContractLocator;
import com.cryption.app.entity.ContractType;
import com.cryption.app.entity.TransferFromEventResponse;
import com.cryption.app.entity.Wallet;
import com.cryption.app.entity.opensea.Asset;
import com.cryption.app.entity.tokens.Token;
import com.cryption.app.entity.tokens.TokenCardMeta;
import com.cryption.app.entity.tokens.TokenInfo;
import com.cryption.app.entity.tokens.TokenTicker;
import com.cryption.app.service.AssetDefinitionService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.realm.Realm;

public interface TokenRepositoryType {

    Observable<Token> fetchActiveTokenBalance(String walletAddress, Token token);
    Single<Boolean> updateTokenBalance(String walletAddress, int chainId, String tokenAddress, ContractType type);
    Single<ContractLocator> getTokenResponse(String address, int chainId, String method);
    Single<Token[]> checkInterface(Token[] tokens, Wallet wallet);
    Completable setEnable(Wallet wallet, Token token, boolean isEnabled);
    Completable setVisibilityChanged(Wallet wallet, Token token);
    Single<TokenInfo> update(String address, int chainId);
    Observable<TransferFromEventResponse> burnListenerObservable(String contractAddress);
    Single<Token> addToken(Wallet wallet, TokenInfo tokenInfo, ContractType interfaceSpec);
    Single<TokenTicker> getEthTicker(int chainId);
    TokenTicker getTokenTicker(Token token);
    Single<BigInteger> fetchLatestBlockNumber(int chainId);
    Token fetchToken(int chainId, String walletAddress, String address);

    Single<Token[]> storeTokens(Wallet wallet, Token[] tokens);
    Single<String> resolveENS(int chainId, String address);
    void updateAssets(String wallet, Token erc721Token, List<BigInteger> additions, List<BigInteger> removals);
    void storeAsset(String currentAddress, Token token, Asset asset);
    Token[] initERC721Assets(Wallet wallet, Token[] token);

    Single<ContractType> determineCommonType(TokenInfo tokenInfo);
    Token updateTokenType(Token token, Wallet wallet, ContractType type);

    Single<Boolean> fetchIsRedeemed(Token token, BigInteger tokenId);

    void addImageUrl(int networkId, String address, String imageUrl);

    Single<TokenCardMeta[]> fetchTokenMetas(Wallet wallet, List<Integer> networkFilters,
                                            AssetDefinitionService svs);

    Single<TokenCardMeta[]> fetchAllTokenMetas(Wallet wallet, List<Integer> networkFilters,
                                            String searchTerm);

    Single<Token[]> fetchTokensThatMayNeedUpdating(String walletAddress, List<Integer> networkFilters);

    TokenCardMeta[] fetchTokenMetasForUpdate(Wallet wallet, List<Integer> networkFilters);

    Realm getRealmInstance(Wallet wallet);
    Realm getTickerRealmInstance();

    Single<BigDecimal> fetchChainBalance(String walletAddress, int chainId);
    Single<Integer> fixFullNames(Wallet wallet, AssetDefinitionService svs);
    
    boolean isEnabled(Token newToken);
    boolean hasVisibilityBeenChanged(Token token);
}
