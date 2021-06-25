package com.cryption.app.di;

import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.router.TransferTicketDetailRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.TransferTicketViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by James on 16/02/2018.
 */

@Module
public class TransferTicketModule
{
    @Provides
    TransferTicketViewModelFactory transferTicketViewModelFactory(
            TokensService tokensService,
            GenericWalletInteract genericWalletInteract,
            TransferTicketDetailRouter transferTicketDetailRouter,
            AssetDefinitionService assetDefinitionService) {
        return new TransferTicketViewModelFactory(
                tokensService, genericWalletInteract, transferTicketDetailRouter, assetDefinitionService);
    }

    @Provides
    GenericWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    TransferTicketDetailRouter provideTransferTicketDetailRouter() {
        return new TransferTicketDetailRouter();
    }
}

