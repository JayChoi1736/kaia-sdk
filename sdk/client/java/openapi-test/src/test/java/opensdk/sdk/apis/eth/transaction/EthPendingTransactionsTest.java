package opensdk.sdk.apis.eth.transaction;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.EthNewPendingTransactionFilterResponse;
import opensdk.sdk.models.EthPendingTransactionsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Eth RPC Test")
public class EthPendingTransactionsTest {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.LOCAL_URL);

    @Test
    @DisplayName("RPC eth_pendingTransactions")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        String transactionHash = "0xaca5d9a1ed8b86b1ef61431b2bedfc99a66eaefc3a7e1cffdf9ff53653956a67";
        EthPendingTransactionsResponse response = sdk.eth.pendingTransactions(transactionHash).send();
        assertNotNull(response.getResult());

    }

}
