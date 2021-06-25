package com.cryption.app.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.repository.CurrencyRepositoryType;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.LocaleRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.router.AddTokenRouter;
import com.cryption.app.router.ImportTokenRouter;
import com.cryption.app.router.MyAddressRouter;
import com.cryption.app.service.AnalyticsServiceType;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.TickerService;
import com.cryption.app.service.TransactionsService;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private final PreferenceRepositoryType preferenceRepository;
    private final ImportTokenRouter importTokenRouter;
    private final AddTokenRouter addTokenRouter;
    private final LocaleRepositoryType localeRepository;
    private final AssetDefinitionService assetDefinitionService;
    private final GenericWalletInteract genericWalletInteract;
    private final FetchWalletsInteract fetchWalletsInteract;
    private final CurrencyRepositoryType currencyRepository;
    private final EthereumNetworkRepositoryType ethereumNetworkRepository;
    private final Context context;
    private final MyAddressRouter myAddressRouter;
    private final TransactionsService transactionsService;
    private final TickerService tickerService;
    private final AnalyticsServiceType analyticsService;

    public HomeViewModelFactory(
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
        this.preferenceRepository = preferenceRepository;
        this.localeRepository = localeRepository;
        this.importTokenRouter = importTokenRouter;
        this.addTokenRouter = addTokenRouter;
        this.assetDefinitionService = assetDefinitionService;
        this.genericWalletInteract = genericWalletInteract;
        this.fetchWalletsInteract = fetchWalletsInteract;
        this.currencyRepository = currencyRepository;
        this.ethereumNetworkRepository = ethereumNetworkRepository;
        this.context = context;
        this.myAddressRouter = myAddressRouter;
        this.transactionsService = transactionsService;
        this.tickerService = tickerService;
        this.analyticsService = analyticsService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel(
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
                analyticsService
        );
    }
}
