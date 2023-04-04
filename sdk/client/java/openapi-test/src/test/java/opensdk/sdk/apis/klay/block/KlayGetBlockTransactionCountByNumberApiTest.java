package opensdk.sdk.apis.klay.block;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.KlayGetBlockTransactionCountByNumberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

@DisplayName("Klay RPC Test")
public class KlayGetBlockTransactionCountByNumberApiTest {

    private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);

    @Test
    @DisplayName("RPC klay_getBlockTransactionCountByNumber")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        KlayGetBlockTransactionCountByNumberResponse gr = sdk.klay.getBlockTransactionCountByNumber(
            "0xe8")
        .send();
        gr.getResult();
    }
}
