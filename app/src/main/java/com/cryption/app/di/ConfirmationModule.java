package com.cryption.app.di;


import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.router.GasSettingsRouter;
import com.cryption.app.service.GasService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.ConfirmationViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfirmationModule {
    @Provides
    public ConfirmationViewModelFactory provideConfirmationViewModelFactory(
            GenericWalletInteract genericWalletInteract,
            GasService gasService,
            CreateTransactionInteract createTransactionInteract,
            GasSettingsRouter gasSettingsRouter,
            TokensService tokensService,
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            KeyService keyService
    ) {
        return new ConfirmationViewModelFactory(
                genericWalletInteract,
                gasService,
                createTransactionInteract,
                gasSettingsRouter,
                tokensService,
                findDefaultNetworkInteract,
                keyService);
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
    GasSettingsRouter provideGasSettingsRouter() {
        return new GasSettingsRouter();
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType networkRepository) {
        return new FindDefaultNetworkInteract(networkRepository);
    }
}
