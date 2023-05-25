package opensdk.sdk.apis.eth.transaction;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Eth RPC Test")
public class EthGetTransactionByBlockNumberAndIndexTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));
    @Test
    @DisplayName("RPC eth_getTransactionByBlockNumberAndIndex")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthTransaction response = w3.ethGetTransactionByBlockNumberAndIndex(
            DefaultBlockParameter.valueOf(new BigInteger("0x27", 16)), 
            new BigInteger("0x0", 16))
        .send();
        assertNotNull(response);
        assertNull(response.getError());

    }
}
