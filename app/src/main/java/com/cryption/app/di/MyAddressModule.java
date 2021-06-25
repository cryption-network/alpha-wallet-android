package com.cryption.app.di;

import dagger.Module;
import dagger.Provides;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.MyAddressViewModelFactory;

@Module
class MyAddressModule {
    @Provides
    MyAddressViewModelFactory provideMyAddressViewModelFactory(
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            TokensService tokensService) {
        return new MyAddressViewModelFactory(
                ethereumNetworkRepository,
                tokensService);
    }
}
