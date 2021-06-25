package com.cryption.app.di;

import com.cryption.app.interact.AddTokenInteract;
import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.router.MyAddressRouter;
import com.cryption.app.service.AnalyticsServiceType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.GasService2;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.SendViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class SendModule {

    @Provides
    SendViewModelFactory provideSendViewModelFactory(MyAddressRouter myAddressRouter,
                                                     EthereumNetworkRepositoryType networkRepositoryType,
                                                     TokensService tokensService,
                                                     FetchTransactionsInteract fetchTransactionsInteract,
                                                     AddTokenInteract addTokenInteract,
                                                     CreateTransactionInteract createTransactionInteract,
                                                     GasService2 gasService,
                                                     AssetDefinitionService assetDefinitionService,
                                                     KeyService keyService,
                                                     AnalyticsServiceType analyticsService) {
        return new SendViewModelFactory(myAddressRouter,
                networkRepositoryType,
                tokensService,
                fetchTransactionsInteract,
                addTokenInteract,
                createTransactionInteract,
                gasService,
                assetDefinitionService,
                keyService,
                analyticsService);
    }

    @Provides
    MyAddressRouter provideMyAddressRouter() {
        return new MyAddressRouter();
    }

    @Provides
    AddTokenInteract provideAddTokenInteract(
            TokenRepositoryType tokenRepository) {
        return new AddTokenInteract(tokenRepository);
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository)
    {
        return new CreateTransactionInteract(transactionRepository);
    }
}
