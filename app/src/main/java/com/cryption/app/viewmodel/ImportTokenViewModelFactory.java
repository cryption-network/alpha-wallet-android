package com.cryption.app.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.interact.AddTokenInteract;
import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FetchTokensInteract;
import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.service.AlphaWalletService;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.GasService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;

/**
 * Created by James on 9/03/2018.
 */

public class ImportTokenViewModelFactory implements ViewModelProvider.Factory {

    private final GenericWalletInteract genericWalletInteract;
    private final CreateTransactionInteract createTransactionInteract;
    private final FetchTokensInteract fetchTokensInteract;
    private final TokensService tokensService;
    private final AlphaWalletService alphaWalletService;
    private final AddTokenInteract addTokenInteract;
    private final EthereumNetworkRepositoryType ethereumNetworkRepository;
    private final AssetDefinitionService assetDefinitionService;
    private final FetchTransactionsInteract fetchTransactionsInteract;
    private final GasService gasService;
    private final KeyService keyService;

    public ImportTokenViewModelFactory(GenericWalletInteract genericWalletInteract,
                                       CreateTransactionInteract createTransactionInteract,
                                       FetchTokensInteract fetchTokensInteract,
                                       TokensService tokensService,
                                       AlphaWalletService alphaWalletService,
                                       AddTokenInteract addTokenInteract,
                                       EthereumNetworkRepositoryType ethereumNetworkRepository,
                                       AssetDefinitionService assetDefinitionService,
                                       FetchTransactionsInteract fetchTransactionsInteract,
                                       GasService gasService,
                                       KeyService keyService) {
        this.genericWalletInteract = genericWalletInteract;
        this.createTransactionInteract = createTransactionInteract;
        this.fetchTokensInteract = fetchTokensInteract;
        this.tokensService = tokensService;
        this.alphaWalletService = alphaWalletService;
        this.addTokenInteract = addTokenInteract;
        this.ethereumNetworkRepository = ethereumNetworkRepository;
        this.assetDefinitionService = assetDefinitionService;
        this.fetchTransactionsInteract = fetchTransactionsInteract;
        this.gasService = gasService;
        this.keyService = keyService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ImportTokenViewModel(genericWalletInteract, createTransactionInteract, fetchTokensInteract, tokensService, alphaWalletService, addTokenInteract, ethereumNetworkRepository, assetDefinitionService, fetchTransactionsInteract, gasService, keyService);
    }
}

