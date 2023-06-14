package opensdk.sdk.apis.klay.configuration;


import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.KlayRewardbaseResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@DisplayName("Eth RPC Test")
public class KlayRewardBaseTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));
    @Test
    @DisplayName("RPC klay_rewardbase")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        KlayRewardbaseResponse response = w3.klayRewardbase().send();

        assertNotNull(response);
        assertNull(response.getError());
    }
}
