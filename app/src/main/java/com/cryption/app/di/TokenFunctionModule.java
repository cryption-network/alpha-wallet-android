package com.cryption.app.di;

import com.cryption.app.interact.CreateTransactionInteract;
import com.cryption.app.interact.FetchTransactionsInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.TokenRepositoryType;
import com.cryption.app.repository.TransactionRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.router.TransferTicketDetailRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.GasService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.OpenseaService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.TokenFunctionViewModelFactory;

import dagger.Module;
import dagger.Provides;
/**
 * Created by James on 2/04/2019.
 * Stormbird in Singapore
 */

@Module
public class TokenFunctionModule
{
    @Provides
    TokenFunctionViewModelFactory provideTokenFunctionViewModelFactory(
            AssetDefinitionService assetDefinitionService,
            CreateTransactionInteract createTransactionInteract,
            GasService gasService,
            TokensService tokensService,
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            KeyService keyService,
            GenericWalletInteract genericWalletInteract,
            OpenseaService openseaService,
            FetchTransactionsInteract fetchTransactionsInteract) {

        return new TokenFunctionViewModelFactory(
                assetDefinitionService, createTransactionInteract, gasService, tokensService, ethereumNetworkRepository, keyService, genericWalletInteract, openseaService, fetchTransactionsInteract);
    }

    @Provides
    TransferTicketDetailRouter provideTransferTicketRouter() {
        return new TransferTicketDetailRouter();
    }

    @Provides
    CreateTransactionInteract provideCreateTransactionInteract(TransactionRepositoryType transactionRepository) {
        return new CreateTransactionInteract(transactionRepository);
    }

    @Provides
    GenericWalletInteract provideGenericWalletInteract(WalletRepositoryType walletRepository) {
        return new GenericWalletInteract(walletRepository);
    }

    @Provides
    FetchTransactionsInteract provideFetchTransactionsInteract(TransactionRepositoryType transactionRepository,
                                                               TokenRepositoryType tokenRepositoryType) {
        return new FetchTransactionsInteract(transactionRepository, tokenRepositoryType);
    }
}
