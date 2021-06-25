package com.cryption.app.service;

import com.cryption.app.entity.NetworkInfo;
import com.cryption.app.entity.Transaction;
import com.cryption.app.entity.TransactionMeta;

import io.reactivex.Single;

public interface TransactionsNetworkClientType {
    Single<Transaction[]> storeNewTransactions(String walletAddress, NetworkInfo networkInfo, String tokenAddress, long lastBlock);
    Single<TransactionMeta[]> fetchMoreTransactions(String walletAddress, NetworkInfo network, long lastTxTime);
    Single<Integer> readTransfers(String currentAddress, NetworkInfo networkByChain, TokensService tokensService, boolean nftCheck);
    void checkTransactionsForEmptyFunctions(String currentAddress);
}
