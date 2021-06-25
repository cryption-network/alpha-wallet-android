package com.cryption.app.di;

import android.content.Context;

import com.cryption.app.interact.FetchWalletsInteract;
import com.cryption.app.interact.FindDefaultNetworkInteract;
import com.cryption.app.interact.GenericWalletInteract;
import com.cryption.app.interact.SetDefaultWalletInteract;
import com.cryption.app.repository.EthereumNetworkRepositoryType;
import com.cryption.app.repository.WalletRepositoryType;
import com.cryption.app.router.HomeRouter;
import com.cryption.app.router.ImportWalletRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.service.KeyService;
import com.cryption.app.service.TokensService;
import com.cryption.app.viewmodel.WalletsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class AccountsManageModule {

	@Provides
    WalletsViewModelFactory provideAccountsManageViewModelFactory(
			SetDefaultWalletInteract setDefaultWalletInteract,
			FetchWalletsInteract fetchWalletsInteract,
			GenericWalletInteract genericWalletInteract,
			ImportWalletRouter importWalletRouter,
			HomeRouter homeRouter,
			FindDefaultNetworkInteract findDefaultNetworkInteract,
			KeyService keyService,
			TokensService tokensService,
			AssetDefinitionService assetDefinitionService,
			Context context)
	{
		return new WalletsViewModelFactory(setDefaultWalletInteract,
				fetchWalletsInteract,
				genericWalletInteract,
				importWalletRouter,
				homeRouter,
				findDefaultNetworkInteract,
				keyService,
				tokensService,
				assetDefinitionService,
				context);
	}

	@Provides
    SetDefaultWalletInteract provideSetDefaultAccountInteract(WalletRepositoryType accountRepository) {
		return new SetDefaultWalletInteract(accountRepository);
	}

	@Provides
    FetchWalletsInteract provideFetchAccountsInteract(WalletRepositoryType accountRepository) {
		return new FetchWalletsInteract(accountRepository);
	}

	@Provides
    GenericWalletInteract provideFindDefaultAccountInteract(WalletRepositoryType accountRepository) {
		return new GenericWalletInteract(accountRepository);
	}

	@Provides
    ImportWalletRouter provideImportAccountRouter() {
		return new ImportWalletRouter();
	}

	@Provides
    HomeRouter provideHomeRouter() {
	    return new HomeRouter();
    }

	@Provides
	FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
			EthereumNetworkRepositoryType networkRepository) {
		return new FindDefaultNetworkInteract(networkRepository);
	}
}
