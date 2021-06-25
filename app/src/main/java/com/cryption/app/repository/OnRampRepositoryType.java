package com.cryption.app.repository;

import com.cryption.app.entity.OnRampContract;
import com.cryption.app.entity.tokens.Token;

public interface OnRampRepositoryType {
    String getUri(String address, Token token);

    OnRampContract getContract(Token token);
}
