package com.cryption.app.web3.entity;

import com.cryption.app.entity.DAppFunction;
import com.cryption.token.entity.Signable;

/**
 * Created by James on 6/04/2019.
 * Stormbird in Singapore
 */
public interface FunctionCallback
{
    void signMessage(Signable sign, DAppFunction dAppFunction);
    void functionSuccess();
    void functionFailed();
}
