package com.cryption.app.viewmodel;

import com.cryption.app.entity.NetworkInfo;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.service.TokensService;

public class MyAddressViewModel extends BaseViewModel {
    private final EthereumNetworkRepositoryType ethereumNetworkRepository;
    private final TokensService tokenService;

    MyAddressViewModel(
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            TokensService tokensService) {
        this.ethereumNetworkRepository = ethereumNetworkRepository;
        this.tokenService = tokensService;
    }

    public TokensService getTokenService() {
        return tokenService;
    }

    public EthereumNetworkRepositoryType getEthereumNetworkRepository() {
        return ethereumNetworkRepository;
    }

    public NetworkInfo getNetworkByChain(int chainId) {
        return ethereumNetworkRepository.getNetworkByChain(chainId);
    }
}
