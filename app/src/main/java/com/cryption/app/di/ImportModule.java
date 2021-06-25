package com.cryption.app.di;

import com.cryption.app.interact.ImportWalletInteract;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.AnalyticsServiceType;
import com.cryption.app.service.GasService;
import com.cryption.app.service.KeyService;
import com.cryption.app.viewmodel.ImportWalletViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class ImportModule {
    @Provides
    ImportWalletViewModelFactory provideImportWalletViewModelFactory(
            ImportWalletInteract importWalletInteract,
            KeyService keyService,
            GasService gasService,
            AnalyticsServiceType analyticsService) {
        return new ImportWalletViewModelFactory(importWalletInteract, keyService, gasService, analyticsService);
    }

    @Provides
    ImportWalletInteract provideImportWalletInteract(
            WalletRepositoryType walletRepository) {
        return new ImportWalletInteract(walletRepository);
    }
}
