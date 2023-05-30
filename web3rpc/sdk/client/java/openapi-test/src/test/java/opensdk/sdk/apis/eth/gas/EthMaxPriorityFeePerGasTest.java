package opensdk.sdk.apis.eth.gas;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.core.methods.response.EthMaxPriorityFeePerGas;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EthMaxPriorityFeePerGasTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));
    @Test
    @DisplayName("RPC eth_maxPriorityFeePerGas")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        EthMaxPriorityFeePerGas response = w3.ethMaxPriorityFeePerGas().send();
        assertNotNull(response);
        assertNull(response.getError());
    }
}
