package com.cryption.app.di;

import dagger.Module;
import dagger.Provides;

import com.cryption.app.interact.AddTokenInteract;
import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FetchTokensInteract;
import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.AlphaWalletService;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.GasService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.ImportTokenViewModelFactory;

/**
 * Created by James on 9/03/2018.
 */

@Module
public class ImportTokenModule {

    @Provides
    ImportTokenViewModelFactory importTokenViewModelFactory(
            GenericWalletInteract genericWalletInteract,
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
        return new ImportTokenViewModelFactory(
                genericWalletInteract, createTransactionInteract, fetchTokensInteract, tokensService, alphaWalletService, addTokenInteract, ethereumNetworkRepository, assetDefinitionService, fetchTransactionsInteract, gasService, keyService);
    }

    @Provides
    GenericWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository) {
        return new CreateTransactionInteract(transactionRepository);
    }

    @Provides
    FetchTokensInteract provideFetchTokensInteract(TokenRepositoryType tokenRepository) {
        return new FetchTokensInteract(tokenRepository);
    }

    @Provides
    AddTokenInteract provideAddTokenInteract(
            TokenRepositoryType tokenRepository) {
        return new AddTokenInteract(tokenRepository);
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository, TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }
}
