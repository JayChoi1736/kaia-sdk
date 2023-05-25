package opensdk.sdk.apis.eth.block;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetUncleCountByBlockNumber;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Eth RPC Test")

public class EthGetUncleCountByBlockNumberTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));
    @Test
    @DisplayName("RPC eth_getUncleCountByBlockNumber")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthGetUncleCountByBlockNumber response = w3.ethGetUncleCountByBlockNumber(
            DefaultBlockParameter.valueOf(new BigInteger("0xe8", 16)))
        .send();
        assertNotNull(response);
        assertNull(response.getError());
    }
}
