package com.cryption.app.entity;

import com.cryption.token.entity.Signable;

public interface DAppFunction
{
    void DAppError(Throwable error, Signable message);
    void DAppReturn(byte[] data, Signable message);
}
