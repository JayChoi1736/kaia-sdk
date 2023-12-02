package opensdk.sdk.apis.debug.vMTracing;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import org.web3j.protocol.klaytn.core.method.response.DebugTraceBadBlockResponse;

@DisplayName("Debug RPC Test")
public class DebugTraceCallTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.BAOBAB_RPC));

    @Disabled
    @Test
    @DisplayName("RPC debug_traceBadBlock")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        String blockHash = "0x1d5ba00e313a81ae6d409d459c153327072665d9ea2f47608369722baf0cfbb6";

        DebugTraceBadBlockResponse response = w3.debugTraceBadBlock(blockHash, null).send();

        assertNotNull(response);
        assertNull(response.getError());
        assertNotNull(response.getResult());
    }
}
