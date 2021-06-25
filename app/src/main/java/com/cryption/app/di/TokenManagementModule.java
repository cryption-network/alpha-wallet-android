package com.cryption.app.di;

import com.cryption.app.interact.ChangeTokenEnableInteract;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.router.AddTokenRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.TokenManagementViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class TokenManagementModule {
    @Provides
    TokenManagementViewModelFactory provideTokenManagementViewModelFactory(
            TokenRepositoryType tokenRepository,
            ChangeTokenEnableInteract changeTokenEnableInteract,
            AddTokenRouter addTokenRouter,
            AssetDefinitionService assetDefinitionService,
            TokensService tokensService)
    {
        return new TokenManagementViewModelFactory(tokenRepository, changeTokenEnableInteract, addTokenRouter, assetDefinitionService, tokensService);
    }

    @Provides
    ChangeTokenEnableInteract provideChangeTokenEnableInteract(TokenRepositoryType tokenRepository) {
        return new ChangeTokenEnableInteract(tokenRepository);
    }

    @Provides
    AddTokenRouter provideAddTokenRouter() {
        return new AddTokenRouter();
    }
}
