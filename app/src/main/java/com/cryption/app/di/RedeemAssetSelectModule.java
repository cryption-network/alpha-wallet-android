package com.cryption.app.di;

import com.cryption.app.router.RedeemSignatureDisplayRouter;
import com.cryption.app.service.AssetDefinitionService;
import com.cryption.app.viewmodel.RedeemAssetSelectViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by James on 27/02/2018.
 */

@Module
public class RedeemAssetSelectModule
{
    @Provides
    RedeemAssetSelectViewModelFactory redeemTokenSelectViewModelFactory(
            RedeemSignatureDisplayRouter redeemSignatureDisplayRouter,
            AssetDefinitionService assetDefinitionService) {

        return new RedeemAssetSelectViewModelFactory(redeemSignatureDisplayRouter, assetDefinitionService);
    }

    @Provides
    RedeemSignatureDisplayRouter provideRedeemSignatureDisplayRouter() {
        return new RedeemSignatureDisplayRouter();
    }
}
