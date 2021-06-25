package com.cryption.app.di;

import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.router.ExternalBrowserRouter;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.TransactionDetailViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class TransactionDetailModule {

    @Provides
    TransactionDetailViewModelFactory provideTransactionDetailViewModelFactory(
            FindDefaultNetworkInteract findDefaultNetworkInteract,
            ExternalBrowserRouter externalBrowserRouter,
            TokenRepositoryType tokenRepository,
            TokensService tokensService,
            FetchTransactionsInteract fetchTransactionsInteract) {
        return new TransactionDetailViewModelFactory(
                findDefaultNetworkInteract, externalBrowserRouter, tokenRepository, tokensService, fetchTransactionsInteract);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType ethereumNetworkRepository) {
        return new FindDefaultNetworkInteract(ethereumNetworkRepository);
    }

    @Provides
    ExternalBrowserRouter externalBrowserRouter() {
        return new ExternalBrowserRouter();
    }

    @Provides
    GenericWalletInteract findDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }
}
