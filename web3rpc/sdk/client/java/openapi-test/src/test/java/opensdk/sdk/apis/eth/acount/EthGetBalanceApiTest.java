package opensdk.sdk.apis.eth.acount;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

@DisplayName("Eth RPC Test")
public class EthGetBalanceApiTest {

    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));

    @Test
    @DisplayName("RPC eth_getBalance")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthGetBalance br = w3.ethGetBalance(
            "0xc94770007dda54cF92009BFF0dE90c06F603a09f",
            DefaultBlockParameter.valueOf("latest"))
        .send();
        assertNotNull(br);
        assertNull(br.getError());
    }
}
