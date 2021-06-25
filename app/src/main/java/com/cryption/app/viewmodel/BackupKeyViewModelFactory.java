package com.cryption.app.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.interact.ExportWalletInteract;
import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.service.KeyService;

import javax.inject.Inject;

public class BackupKeyViewModelFactory implements ViewModelProvider.Factory {
    private final KeyService keyService;
    private final ExportWalletInteract exportWalletInteract;
    private final FetchWalletsInteract fetchWalletsInteract;

    @Inject
    public BackupKeyViewModelFactory(
            KeyService keyService,
            ExportWalletInteract exportWalletInteract,
            FetchWalletsInteract fetchWalletsInteract) {
        this.keyService = keyService;
        this.exportWalletInteract = exportWalletInteract;
        this.fetchWalletsInteract = fetchWalletsInteract;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BackupKeyViewModel(
                keyService,
                exportWalletInteract,
                fetchWalletsInteract);
    }
}
