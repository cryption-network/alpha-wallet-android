package com.cryption.app.di;

import com.cryption.app.ui.ActivityFragment;
import com.cryption.app.ui.AddTokenActivity;
import com.cryption.app.ui.AdvancedSettingsActivity;
import com.cryption.app.ui.AssetDisplayActivity;
import com.cryption.app.ui.BackupKeyActivity;
import com.cryption.app.ui.ConfirmationActivity;
import com.cryption.app.ui.DappBrowserFragment;
import com.cryption.app.ui.Erc20DetailActivity;
import com.cryption.app.ui.FunctionActivity;
import com.cryption.app.ui.GasSettingsActivity;
import com.cryption.app.ui.GasSettingsActivityLegacy;
import com.cryption.app.ui.HelpActivity;
import com.cryption.app.ui.HomeActivity;
import com.cryption.app.ui.ImportTokenActivity;
import com.cryption.app.ui.ImportWalletActivity;
import com.cryption.app.ui.MyAddressActivity;
import com.cryption.app.ui.NewSettingsFragment;
import com.cryption.app.ui.RedeemAssetSelectActivity;
import com.cryption.app.ui.RedeemSignatureDisplayActivity;
import com.cryption.app.ui.SelectNetworkActivity;
import com.cryption.app.ui.SelectNetworkFilterActivity;
import com.cryption.app.ui.SellDetailActivity;
import com.cryption.app.ui.SendActivity;
import com.cryption.app.ui.SplashActivity;
import com.cryption.app.ui.TokenActivity;
import com.cryption.app.ui.TokenDetailActivity;
import com.cryption.app.ui.TokenFunctionActivity;
import com.cryption.app.ui.TokenManagementActivity;
import com.cryption.app.ui.TokenScriptManagementActivity;
import com.cryption.app.ui.TransactionDetailActivity;
import com.cryption.app.ui.TransferTicketActivity;
import com.cryption.app.ui.TransferTicketDetailActivity;
import com.cryption.app.ui.WalletActionsActivity;
import com.cryption.app.ui.WalletConnectActivity;
import com.cryption.app.ui.WalletConnectSessionActivity;
import com.cryption.app.ui.WalletFragment;
import com.cryption.app.ui.WalletsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {
	@ActivityScope
	@ContributesAndroidInjector(modules = SplashModule.class)
	abstract SplashActivity bindSplashModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = AccountsManageModule.class)
	abstract WalletsActivity bindManageWalletsModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = ImportModule.class)
	abstract ImportWalletActivity bindImportWalletModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = TransactionDetailModule.class)
	abstract TransactionDetailActivity bindTransactionDetailModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = SendModule.class)
	abstract SendActivity bindSendModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = ConfirmationModule.class)
	abstract ConfirmationActivity bindConfirmationModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = GasSettingsModule.class)
	abstract GasSettingsActivity bindGasSettingsModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = GasSettingsModule.class)
	abstract GasSettingsActivityLegacy bindGasSettingsLegacyModule();

	@ActivityScope
	@ContributesAndroidInjector(modules = AddTokenModule.class)
	abstract AddTokenActivity bindAddTokenActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = RedeemSignatureDisplayModule.class)
	abstract RedeemSignatureDisplayActivity bindSignatureDisplayActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TokenFunctionModule.class)
	abstract AssetDisplayActivity bindAssetDisplayActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = SellDetailModule.class)
	abstract SellDetailActivity bindSellDetailsActivity();

	@FragmentScope
	@ContributesAndroidInjector(modules = NewSettingsModule.class)
	abstract NewSettingsFragment bindNewSettingsFragment();

	@FragmentScope
	@ContributesAndroidInjector(modules = ActivityModule.class)
	abstract ActivityFragment bindActivityFragment();

	@ActivityScope
	@ContributesAndroidInjector(modules = RedeemAssetSelectModule.class)
	abstract RedeemAssetSelectActivity bindRedeemTokenSelectActivity();

	@FragmentScope
	@ContributesAndroidInjector(modules = WalletModule.class)
	abstract WalletFragment bindWalletFragment();

	@ActivityScope
	@ContributesAndroidInjector(modules = HomeModule.class)
	abstract HomeActivity bindHomeActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = ImportTokenModule.class)
	abstract ImportTokenActivity bindImportTokenActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TransferTicketDetailModule.class)
	abstract TransferTicketDetailActivity bindTransferTicketDetailActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TransferTicketModule.class)
	abstract TransferTicketActivity bindTransferTicketActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = HelpModule.class)
	abstract HelpActivity bindHelpActivity();

	@FragmentScope
	@ContributesAndroidInjector(modules = DappBrowserModule.class)
	abstract DappBrowserFragment bindDappBrowserFragment();

	@ActivityScope
	@ContributesAndroidInjector(modules = Erc20DetailModule.class)
	abstract Erc20DetailActivity bindErc20DetailActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = WalletActionsModule.class)
	abstract WalletActionsActivity bindWalletActionsActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = BackupKeyModule.class)
	abstract BackupKeyActivity bindBackupKeyActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = MyAddressModule.class)
	abstract MyAddressActivity bindMyAddressActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TokenFunctionModule.class)
	abstract TokenFunctionActivity bindTokenFunctionActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TokenFunctionModule.class)
	abstract FunctionActivity bindFunctionActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TokenFunctionModule.class)
	abstract TokenDetailActivity bindTokenDetailActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = TokenFunctionModule.class)
	abstract TokenActivity bindTokenActivity();

	@ContributesAndroidInjector(modules = SelectNetworkModule.class)
	abstract SelectNetworkActivity bindSelectNetworkActivity();

	@ContributesAndroidInjector(modules = SelectNetworkFilterModule.class)
	abstract SelectNetworkFilterActivity bindSelectNetworkFilterActivity();

	@ContributesAndroidInjector(modules = TokenManagementModule.class)
	abstract TokenManagementActivity bindTokenManagementActivity();

	@ContributesAndroidInjector(modules = AdvancedSettingsModule.class)
	abstract AdvancedSettingsActivity bindAdvancedSettingsActivity();

    @ActivityScope
	@ContributesAndroidInjector(modules = TokenScriptManagementModule.class)
	abstract TokenScriptManagementActivity bindTokenScriptManagementActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = WalletConnectModule.class)
	abstract WalletConnectActivity bindWalletConnectActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = WalletConnectModule.class)
	abstract WalletConnectSessionActivity bindWalletConnectSessionActivity();
}
