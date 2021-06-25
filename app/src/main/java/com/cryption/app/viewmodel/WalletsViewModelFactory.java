package com.cryption.app.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.interact.SetDefaultWalletInteract;
import com.cryption.app.router.HomeRouter;
import com.cryption.app.router.ImportWalletRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;

import javax.inject.Inject;

public class WalletsViewModelFactory implements ViewModelProvider.Factory {
    private final SetDefaultWalletInteract setDefaultWalletInteract;
    private final FetchWalletsInteract fetchWalletsInteract;
    private final GenericWalletInteract genericWalletInteract;
    private final FindDefaultNetworkInteract findDefaultNetworkInteract;
    private final ImportWalletRouter importWalletRouter;
    private final HomeRouter homeRouter;
    private final KeyService keyService;
    private final TokensService tokensService;
    private final AssetDefinitionService assetService;
    private final Context context;

    @Inject
    public WalletsViewModelFactory(
            SetDefaultWalletInteract setDefaultWalletInteract,
            FetchWalletsInteract fetchWalletsInteract,
            GenericWalletInteract genericWalletInteract,
            ImportWalletRouter importWalletRouter,
            HomeRouter homeRouter,
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            KeyService keyService,
            TokensService tokensService,
            AssetDefinitionService assetService,
            Context context) {
        this.setDefaultWalletInteract = setDefaultWalletInteract;
        this.fetchWalletsInteract = fetchWalletsInteract;
        this.genericWalletInteract = genericWalletInteract;
        this.importWalletRouter = importWalletRouter;
        this.homeRouter = homeRouter;
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.keyService = keyService;
        this.tokensService = tokensService;
        this.assetService = assetService;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WalletsViewModel(
                setDefaultWalletInteract,
                fetchWalletsInteract,
                genericWalletInteract,
                importWalletRouter,
                homeRouter,
                findDefaultNetworkInteract,
                keyService,
                tokensService,
                assetService,
                context);
    }
}
