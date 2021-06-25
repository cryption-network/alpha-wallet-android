package com.cryption.app.di;

import dagger.Module;
import dagger.Provides;

import com.cryption.app.interact.ExportWalletInteract;
import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.KeyService;
import com.cryption.app.viewmodel.BackupKeyViewModelFactory;

@Module
public class BackupKeyModule {
    @Provides
    BackupKeyViewModelFactory provideBackupKeyViewModelFactory(
            KeyService keyService,
            ExportWalletInteract exportWalletInteract,
            FetchWalletsInteract fetchWalletsInteract) {
        return new BackupKeyViewModelFactory(
                keyService,
                exportWalletInteract,
                fetchWalletsInteract);
    }

    @Provides
    ExportWalletInteract provideExportWalletInteract(
            WalletRepositoryType walletRepository) {
        return new ExportWalletInteract(walletRepository);
    }

    @Provides
    FetchWalletsInteract provideFetchAccountsInteract(WalletRepositoryType accountRepository) {
        return new FetchWalletsInteract(accountRepository);
    }
}