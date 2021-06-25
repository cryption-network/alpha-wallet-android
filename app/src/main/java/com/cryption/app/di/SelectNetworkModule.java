package com.cryption.app.di;

import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.PreferenceRepositoryType;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.SelectNetworkViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class SelectNetworkModule {
    @Provides
    SelectNetworkViewModelFactory provideSelectNetworkViewModelFactory(EthereumNetworkRepositoryType networkRepositoryType,
                                                                       TokensService tokensService,
                                                                       PreferenceRepositoryType preferenceRepositoryType)
    {
        return new SelectNetworkViewModelFactory(networkRepositoryType, tokensService, preferenceRepositoryType);
    }
}
