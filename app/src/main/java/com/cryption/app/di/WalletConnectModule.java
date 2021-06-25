package com.cryption.app.di;

import android.content.Context;

import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.AnalyticsServiceType;
import com.cryption.app.service.GasService2;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.RealmManager;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.WalletConnectViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class WalletConnectModule {
    @Provides
    WalletConnectViewModelFactory provideWalletConnectViewModelFactory(
            KeyService keyService,
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            CreateTransactionInteract createTransactionInteract,
            GenericWalletInteract genericWalletInteract,
            RealmManager realmManager,
            GasService2 gasService,
            TokensService tokensService,
            AnalyticsServiceType analyticsServiceType,
            Context context) {
        return new WalletConnectViewModelFactory(
                keyService,
                findDefaultNetworkInteract,
                createTransactionInteract,
                genericWalletInteract,
                realmManager,
                gasService,
                tokensService,
                analyticsServiceType,
                context);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType ethereumNetworkRepositoryType) {
        return new FindDefaultNetworkInteract(ethereumNetworkRepositoryType);
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository) {
        return new CreateTransactionInteract(transactionRepository);
    }

    @Provides
    GenericWalletInteract provideGenericWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }
}
