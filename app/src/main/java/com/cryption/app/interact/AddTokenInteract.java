package com.cryption.app.interact;

import com.cryption.app.entity.ContractType;
import com.cryption.app.entity.tokens.Token;
import com.cryption.app.entity.tokens.TokenInfo;
import com.cryption.app.entity.Wallet;
import com.cryption.app.repository.TokenRepositoryType;

import io.reactivex.Observable;

public class AddTokenInteract {
    private final TokenRepositoryType tokenRepository;

    public AddTokenInteract(
            TokenRepositoryType tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Observable<Token> add(TokenInfo tokenInfo, ContractType type, Wallet wallet) {
        return tokenRepository
                        .addToken(wallet, tokenInfo, type).toObservable();
    }
}
