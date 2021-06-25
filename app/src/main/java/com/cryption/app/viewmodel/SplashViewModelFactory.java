package com.cryption.app.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.repository.CurrencyRepositoryType;
import com.cryption.app.repository.LocaleRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;

public class SplashViewModelFactory implements ViewModelProvider.Factory {

    private final FetchWalletsInteract fetchWalletsInteract;
    private final PreferenceRepositoryType preferenceRepository;
    private final LocaleRepositoryType localeRepository;
    private final KeyService keyService;
    private final AssetDefinitionService assetDefinitionService;
    private final CurrencyRepositoryType currencyRepository;

    public SplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract,
                                  PreferenceRepositoryType preferenceRepository,
                                  LocaleRepositoryType localeRepository,
                                  KeyService keyService,
                                  AssetDefinitionService assetDefinitionService,
                                  CurrencyRepositoryType currencyRepository) {
        this.fetchWalletsInteract = fetchWalletsInteract;
        this.preferenceRepository = preferenceRepository;
        this.localeRepository = localeRepository;
        this.keyService = keyService;
        this.assetDefinitionService = assetDefinitionService;
        this.currencyRepository = currencyRepository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SplashViewModel(
                fetchWalletsInteract,
                preferenceRepository,
                localeRepository,
                keyService,
                assetDefinitionService,
                currencyRepository);
    }
}
