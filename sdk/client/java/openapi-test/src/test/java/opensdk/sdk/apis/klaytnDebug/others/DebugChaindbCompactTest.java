package opensdk.sdk.apis.klaytnDebug.others;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.DebugChaindbCompactResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

public class DebugChaindbCompactTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));

    @Test
    @DisplayName("RPC debug_chaindbCompact")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        DebugChaindbCompactResponse response = w3.debugChaindbCompact().send();
        response.getResult();
    }
}
