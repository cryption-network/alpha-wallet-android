package com.cryption.app.di;

import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.AnalyticsServiceType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.GasService2;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.TransferTicketDetailViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by James on 22/02/2018.
 */

@Module
public class TransferTicketDetailModule {

    @Provides
    TransferTicketDetailViewModelFactory transferTicketDetailViewModelFactory(
            GenericWalletInteract genericWalletInteract,
            KeyService keyService,
            CreateTransactionInteract createTransactionInteract,
            FetchTransactionsInteract fetchTransactionsInteract,
            AssetDefinitionService assetDefinitionService,
            GasService2 gasService,
            AnalyticsServiceType analyticsService,
            TokensService tokensService) {
        return new TransferTicketDetailViewModelFactory(genericWalletInteract,
                keyService,
                createTransactionInteract,
                fetchTransactionsInteract,
                assetDefinitionService,
                gasService,
                analyticsService,
                tokensService);
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
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }
}