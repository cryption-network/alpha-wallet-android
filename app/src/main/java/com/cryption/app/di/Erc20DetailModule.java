package com.cryption.app.di;

import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.repository.OnRampRepositoryType;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.router.MyAddressRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.Erc20DetailViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class Erc20DetailModule {
    @Provides
    Erc20DetailViewModelFactory provideErc20DetailViewModelFactory(MyAddressRouter myAddressRouter,
                                                                   FetchTransactionsInteract fetchTransactionsInteract,
                                                                   AssetDefinitionService assetDefinitionService,
                                                                   TokensService tokensService,
                                                                   OnRampRepositoryType onRampRepository) {
        return new Erc20DetailViewModelFactory(myAddressRouter,
                fetchTransactionsInteract,
                assetDefinitionService,
                tokensService,
                onRampRepository);
    }

    @Provides
    MyAddressRouter provideMyAddressRouter() {
        return new MyAddressRouter();
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepositoryType,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepositoryType, tokenRepositoryType);
    }
}
