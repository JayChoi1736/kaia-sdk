package opensdk.sdk.apis.klay.configuration;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.KlayChainIDResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Klay RPC Test")
public class KlayChainIdApiTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.TEST_URL));

    @Test
    @DisplayName("RPC klay_chainID")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        KlayChainIDResponse response = w3.klayChainID().send();

        assertNotNull(response);
        assertNull(response.getError());
        assertTrue(response.getResult() instanceof String);
        assertTrue(((String) response.getResult()).matches("^0x[a-fA-F0-9]+"));
    }
}
