package com.cryption.app.di;

import dagger.Module;
import dagger.Provides;
import com.cryption.app.interact.FetchWalletsInteract;

import com.cryption.app.repository.CurrencyRepository;
import com.cryption.app.repository.CurrencyRepositoryType;
import com.cryption.app.repository.LocaleRepository;
import com.cryption.app.repository.LocaleRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;
import com.cryption.app.viewmodel.SplashViewModelFactory;

@Module
public class SplashModule {

    @Provides
    SplashViewModelFactory provideSplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract,
                                                         PreferenceRepositoryType preferenceRepository,
                                                         LocaleRepositoryType localeRepository,
                                                         KeyService keyService,
                                                         AssetDefinitionService assetDefinitionService,
                                                         CurrencyRepositoryType currencyRepository) {
        return new SplashViewModelFactory(
                fetchWalletsInteract,
                preferenceRepository,
                localeRepository,
                keyService,
                assetDefinitionService,
                currencyRepository);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }

    @Provides
    LocaleRepositoryType provideLocaleRepositoryType(PreferenceRepositoryType preferenceRepository) {
        return new LocaleRepository(preferenceRepository);
    }

    @Provides
    CurrencyRepositoryType provideCurrencyRepositoryType(PreferenceRepositoryType preferenceRepository) {
        return new CurrencyRepository(preferenceRepository);
    }
}
