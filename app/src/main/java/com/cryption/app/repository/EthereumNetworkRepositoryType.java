package com.cryption.app.repository;

import com.cryption.app.entity.ContractLocator;
import com.cryption.app.entity.KnownContract;
import com.cryption.app.entity.NetworkInfo;
import com.cryption.app.entity.Wallet;
import com.cryption.app.entity.tokens.Token;

import org.web3j.protocol.Web3j;

import java.math.BigInteger;
import java.util.List;

import io.reactivex.Single;

public interface EthereumNetworkRepositoryType {
    NetworkInfo getActiveBrowserNetwork();

    void setActiveBrowserNetwork(NetworkInfo networkInfo);

    NetworkInfo getNetworkByChain(int chainId);

    Single<BigInteger> getLastTransactionNonce(Web3j web3j, String walletAddress);

    NetworkInfo[] getAvailableNetworkList();

    void addOnChangeDefaultNetwork(OnNetworkChangeListener onNetworkChanged);

    String getNameById(int id);

    List<Integer> getFilterNetworkList();

    void setFilterNetworkList(int[] networkList);

    List<ContractLocator> getAllKnownContracts(List<Integer> networkFilters);

    Single<Token[]> getBlankOverrideTokens(Wallet wallet);

    Token getBlankOverrideToken();

    Token getBlankOverrideToken(NetworkInfo networkInfo);

    KnownContract readContracts();

    boolean getIsPopularToken(int chain, String address);
}
