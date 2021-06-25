package com.cryption.app.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.CurrencyRepository;
import com.cryption.app.repository.CurrencyRepositoryType;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.LocaleRepository;
import com.cryption.app.repository.LocaleRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.router.AddTokenRouter;
import com.cryption.app.router.ImportTokenRouter;
import com.cryption.app.router.MyAddressRouter;
import com.cryption.app.service.AnalyticsServiceType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.TickerService;
import com.cryption.app.service.TransactionsService;
import com.cryption.app.viewmodel.HomeViewModelFactory;

@Module
class HomeModule {
    @Provides
    HomeViewModelFactory provideHomeViewModelFactory(
            PreferenceRepositoryType preferenceRepository,
            LocaleRepositoryType localeRepository,
            ImportTokenRouter importTokenRouter,
            AddTokenRouter addTokenRouter,
            AssetDefinitionService assetDefinitionService,
            GenericWalletInteract genericWalletInteract,
            FetchWalletsInteract fetchWalletsInteract,
            CurrencyRepositoryType currencyRepository,
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            Context context,
            MyAddressRouter myAddressRouter,
            TransactionsService transactionsService,
            TickerService tickerService,
            AnalyticsServiceType analyticsService) {
        return new HomeViewModelFactory(
                preferenceRepository,
                localeRepository,
                importTokenRouter,
                addTokenRouter,
                assetDefinitionService,
                genericWalletInteract,
                fetchWalletsInteract,
                currencyRepository,
                ethereumNetworkRepository,
                context,
                myAddressRouter,
                transactionsService,
                tickerService,
                analyticsService);
    }

    @Provides
    LocaleRepositoryType provideLocaleRepository(PreferenceRepositoryType preferenceRepository) {
        return new LocaleRepository(preferenceRepository);
    }

    @Provides
    AddTokenRouter provideAddTokenRouter() {
        return new AddTokenRouter();
    }

    @Provides
    ImportTokenRouter providesImportTokenRouter() { return new ImportTokenRouter(); }

    @Provides
    GenericWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }

    @Provides
    CurrencyRepositoryType provideCurrencyRepository(PreferenceRepositoryType preferenceRepository) {
        return new CurrencyRepository(preferenceRepository);
    }

    @Provides
    MyAddressRouter provideMyAddressRouter() {
        return new MyAddressRouter();
    }
}
