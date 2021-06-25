package com.cryption.app.di;

import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.SelectNetworkFilterViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class SelectNetworkFilterModule {
    @Provides
    SelectNetworkFilterViewModelFactory provideSelectNetworkFilterViewModelFactory(EthereumNetworkRepositoryType networkRepositoryType,
                                                                                   TokensService tokensService,
                                                                                   PreferenceRepositoryType preferenceRepositoryType) {
        return new SelectNetworkFilterViewModelFactory(networkRepositoryType, tokensService, preferenceRepositoryType);
    }
}
