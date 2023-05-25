package opensdk.sdk.apis.eth.acount;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetCode;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;
import java.math.BigInteger;

@DisplayName("Eth RPC Test")
public class EthGetCodeApiTest {

    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));

    @Test
    @DisplayName("RPC eth_getCode")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthGetCode br = w3.ethGetCode(
            "0xa94f5374fce5edbc8e2a8697c15331677e6ebf0b",
            DefaultBlockParameter.valueOf(new BigInteger("0x2", 16)))
        .send();
        assertNotNull(br);
        assertNull(br.getError());
    }
}
