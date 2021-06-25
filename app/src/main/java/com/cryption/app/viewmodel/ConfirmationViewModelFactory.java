package com.cryption.app.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.router.GasSettingsRouter;
import com.cryption.app.service.GasService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;

public class ConfirmationViewModelFactory implements ViewModelProvider.Factory {

    private GenericWalletInteract genericWalletInteract;
    private GasService gasService;
    private CreateTransactionInteract createTransactionInteract;
    private GasSettingsRouter gasSettingsRouter;
    private TokensService tokensService;
    private FindDefaultNetworkInteract findDefaultNetworkInteract;
    private KeyService keyService;

    public ConfirmationViewModelFactory(GenericWalletInteract genericWalletInteract,
                                        GasService gasService,
                                        CreateTransactionInteract createTransactionInteract,
                                        GasSettingsRouter gasSettingsRouter,
                                        TokensService tokensService,
                                        FindDefaultNetworkInteract findDefaultNetworkInteract,
                                        KeyService keyService) {
        this.genericWalletInteract = genericWalletInteract;
        this.gasService = gasService;
        this.createTransactionInteract = createTransactionInteract;
        this.gasSettingsRouter = gasSettingsRouter;
        this.tokensService = tokensService;
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.keyService = keyService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ConfirmationViewModel(
                genericWalletInteract,
                gasService,
                createTransactionInteract,
                gasSettingsRouter,
                tokensService,
                findDefaultNetworkInteract,
                keyService);
    }
}
