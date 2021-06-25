package com.cryption.app.viewmodel;

/**
 * Created by James on 25/01/2018.
 */

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FetchTokensInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.interact.MemPoolInteract;
import com.cryption.app.interact.SignatureGenerateInteract;
import com.cryption.app.router.AssetDisplayRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;

/**
 * Created by James on 22/01/2018.
 */

public class RedeemSignatureDisplayModelFactory implements ViewModelProvider.Factory {

    private final GenericWalletInteract genericWalletInteract;
    private final KeyService keyService;
    private final SignatureGenerateInteract signatureGenerateInteract;
    private final CreateTransactionInteract createTransactionInteract;
    private final FetchTokensInteract fetchTokensInteract;
    private final MemPoolInteract memPoolInteract;
    private final AssetDisplayRouter assetDisplayRouter;
    private final AssetDefinitionService assetDefinitionService;

    public RedeemSignatureDisplayModelFactory(
            GenericWalletInteract genericWalletInteract,
            SignatureGenerateInteract signatureGenerateInteract,
            CreateTransactionInteract createTransactionInteract,
            KeyService keyService,
            FetchTokensInteract fetchTokensInteract,
            MemPoolInteract memPoolInteract,
            AssetDisplayRouter assetDisplayRouter,
            AssetDefinitionService assetDefinitionService) {
        this.genericWalletInteract = genericWalletInteract;
        this.keyService = keyService;
        this.signatureGenerateInteract = signatureGenerateInteract;
        this.createTransactionInteract = createTransactionInteract;
        this.fetchTokensInteract = fetchTokensInteract;
        this.memPoolInteract = memPoolInteract;
        this.assetDisplayRouter = assetDisplayRouter;
        this.assetDefinitionService = assetDefinitionService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RedeemSignatureDisplayModel(genericWalletInteract, signatureGenerateInteract, createTransactionInteract, keyService, fetchTokensInteract, memPoolInteract, assetDisplayRouter, assetDefinitionService);
    }
}
