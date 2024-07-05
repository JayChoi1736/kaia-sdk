package opensdk.sdk.apis.subbridge;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;
import org.web3j.protocol.klaytn.core.method.response.SubbridgeChildOperatorNonceResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Klay RPC Test")
public class SubbridgeChildOperatorNonceTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.RPC));

    @Test
    @DisplayName("RPC main_bridge")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        SubbridgeChildOperatorNonceResponse response = w3.subbridgeChildOperatorNonce().send();
        assertNotNull(response);
        assertNull(response.getError());
        assertNotNull(response.getResult());
    }
}
