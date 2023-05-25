package opensdk.sdk.apis.klay.filter;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.KlayNewPendingTransactionFilterResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Klay RPC Test")
public class KlayNewPendingTransactionFilterTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.TEST_URL));
    @Test
    @DisplayName("RPC klay_newPendingTransactionFilter")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        KlayNewPendingTransactionFilterResponse response = w3.klayNewPendingTransactionFilter().send();

        assertNotNull(response);
        assertNull(response.getError());
    }
}
