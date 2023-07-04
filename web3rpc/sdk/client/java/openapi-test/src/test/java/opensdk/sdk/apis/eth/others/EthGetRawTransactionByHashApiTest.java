package opensdk.sdk.apis.eth.others;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.EthGetRawTransactionByHashResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Eth RPC Test")
public class EthGetRawTransactionByHashApiTest {

    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.TEST_URL));

    @Test
    @DisplayName("RPC eth_getRawTransactionByBlockNumberAndIndex")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthGetRawTransactionByHashResponse er = w3.ethGetRawTransactionByHash(
            "0x5bbcde52084defa9d1c7068a811363cc27a25c80d7e495180964673aa5f47687")
        .send();
        assertNotNull(er);
        assertNull(er.getError());
        assertNotNull(er.getResult());
        assertTrue(er.getResult().matches("^0x.*$"));
    }
}
