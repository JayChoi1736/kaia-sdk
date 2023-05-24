package org.web3j.protocol.klaytn.core.klaytnDebug.runtimeDebugging;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.DebugMemStatsResponse;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

public class DebugMemStatsExample {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);

    void debugMemStatsExample() throws IOException {
        DebugMemStatsResponse response = sdk.debug.memStats().send();
        response.getResult();
    }
}
