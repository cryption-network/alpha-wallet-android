package com.cryption.app.di;

import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.TokensService;
import com.cryption.app.service.TransactionsService;
import com.cryption.app.viewmodel.ActivityViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JB on 26/06/2020.
 */
@Module
class ActivityModule
{
    @Provides
    ActivityViewModelFactory provideActivityViewModelFactory(
            GenericWalletInteract genericWalletInteract,
            FetchTransactionsInteract fetchTransactionsInteract,
            AssetDefinitionService assetDefinitionService,
            TokensService tokensService,
            TransactionsService transactionsService) {
        return new ActivityViewModelFactory(
                genericWalletInteract,
                fetchTransactionsInteract,
                assetDefinitionService,
                tokensService,
                transactionsService);
    }

    @Provides
    GenericWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }
}
