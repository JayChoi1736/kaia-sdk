package opensdk.sdk.apis.klay.account;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.KlayGetTransactionCountResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Klay RPC Test")
public class KlayGetTransactionCountTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.BAOBAB_RPC));

    @Test
    @DisplayName("RPC klay_getTransactionCount")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        KlayGetTransactionCountResponse response = w3.klayGetTransactionCount(
                "0xc94770007dda54cF92009BFF0dE90c06F603a09f","latest"
        ).send();

        assertNotNull(response);
        assertNull(response.getError());

        assertNotNull(response.getResult());
        assertTrue(response.getResult().matches("^0x[a-f0-9]+"));
    }

}
