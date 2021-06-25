package com.cryption.app.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.router.SellDetailRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.MarketQueueService;

/**
 * Created by James on 21/02/2018.
 */

public class SellDetailModelFactory implements ViewModelProvider.Factory {

    private FindDefaultNetworkInteract findDefaultNetworkInteract;
    private GenericWalletInteract genericWalletInteract;
    private MarketQueueService marketQueueService;
    private CreateTransactionInteract createTransactionInteract;
    private SellDetailRouter sellDetailRouter;
    private KeyService keyService;
    private AssetDefinitionService assetDefinitionService;

    public SellDetailModelFactory(FindDefaultNetworkInteract findDefaultNetworkInteract,
                                  GenericWalletInteract genericWalletInteract,
                                        MarketQueueService marketQueueService,
                                  CreateTransactionInteract createTransactionInteract,
                                  SellDetailRouter sellDetailRouter,
                                  KeyService keyService,
                                  AssetDefinitionService assetDefinitionService) {
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.genericWalletInteract = genericWalletInteract;
        this.marketQueueService = marketQueueService;
        this.createTransactionInteract = createTransactionInteract;
        this.sellDetailRouter = sellDetailRouter;
        this.keyService = keyService;
        this.assetDefinitionService = assetDefinitionService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SellDetailViewModel(findDefaultNetworkInteract, genericWalletInteract, marketQueueService, createTransactionInteract, sellDetailRouter, keyService, assetDefinitionService);
    }
}

