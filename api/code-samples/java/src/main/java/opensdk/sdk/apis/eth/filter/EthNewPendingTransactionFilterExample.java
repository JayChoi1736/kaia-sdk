package org.web3j.protocol.klaytn.core.eth.filter;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.EthNewPendingTransactionFilterResponse;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

public class EthNewPendingTransactionFilterExample {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.LOCAL_URL);
    void ethNewPendingTransactionFilterExample() throws IOException {
        EthNewPendingTransactionFilterResponse response = sdk.eth.newPendingTransactionFilter().send();
        response.getResult();
    }
}
