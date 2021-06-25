package com.cryption.app.viewmodel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.GasService2;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;

public class DappBrowserViewModelFactory implements ViewModelProvider.Factory {
    private final GenericWalletInteract genericWalletInteract;
    private final AssetDefinitionService assetDefinitionService;
    private final CreateTransactionInteract createTransactionInteract;
    private final TokensService tokensService;
    private final EthereumNetworkRepositoryType ethereumNetworkRepository;
    private final KeyService keyService;
    private final GasService2 gasService;

    public DappBrowserViewModelFactory(
            GenericWalletInteract genericWalletInteract,
            AssetDefinitionService assetDefinitionService,
            CreateTransactionInteract createTransactionInteract,
            TokensService tokensService,
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            KeyService keyService,
            GasService2 gasService) {
        this.genericWalletInteract = genericWalletInteract;
        this.assetDefinitionService = assetDefinitionService;
        this.createTransactionInteract = createTransactionInteract;
        this.tokensService = tokensService;
        this.ethereumNetworkRepository = ethereumNetworkRepository;
        this.keyService = keyService;
        this.gasService = gasService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DappBrowserViewModel(
                genericWalletInteract,
                assetDefinitionService,
                createTransactionInteract,
                tokensService,
                ethereumNetworkRepository,
                keyService,
                gasService);
    }
}
