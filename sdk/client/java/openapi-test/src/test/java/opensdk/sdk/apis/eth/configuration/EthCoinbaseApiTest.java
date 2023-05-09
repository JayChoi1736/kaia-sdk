package opensdk.sdk.apis.eth.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.EthCoinbaseResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

@DisplayName("Eth RPC Test")
public class EthCoinbaseApiTest {

    private final OpenSDK sdk = new OpenSDK(UrlConstants.SERVER_URL);

    @Test
    @DisplayName("RPC eth_coinbase")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthCoinbaseResponse br = sdk.eth.coinbase().send();
        assertNotNull(br);
        assertNull(br.getError());
    }
}
