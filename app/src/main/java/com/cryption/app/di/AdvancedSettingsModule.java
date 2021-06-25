package com.cryption.app.di;

import com.cryption.app.repository.CurrencyRepository;
import com.cryption.app.repository.CurrencyRepositoryType;
import com.cryption.app.repository.LocaleRepository;
import com.cryption.app.repository.LocaleRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.viewmodel.AdvancedSettingsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class AdvancedSettingsModule {
    @Provides
    AdvancedSettingsViewModelFactory provideAdvancedSettingsViewModelFactory(
            LocaleRepositoryType localeRepository,
            CurrencyRepositoryType currencyRepository,
            AssetDefinitionService assetDefinitionService,
            PreferenceRepositoryType preferenceRepository
    ) {
        return new AdvancedSettingsViewModelFactory(
                localeRepository,
                currencyRepository,
                assetDefinitionService,
                preferenceRepository);
    }

    @Provides
    LocaleRepositoryType provideLocaleRepository(PreferenceRepositoryType preferenceRepository) {
        return new LocaleRepository(preferenceRepository);
    }

    @Provides
    CurrencyRepositoryType provideCurrencyRepository(PreferenceRepositoryType preferenceRepository) {
        return new CurrencyRepository(preferenceRepository);
    }
}
