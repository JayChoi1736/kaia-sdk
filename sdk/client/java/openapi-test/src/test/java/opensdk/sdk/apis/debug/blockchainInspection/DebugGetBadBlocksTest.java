package opensdk.sdk.apis.debug.blockchainInspection;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.DebugGetBadBlocksResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Debug RPC Test")
public class DebugGetBadBlocksTest {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.SERVER_URL);

    @Test
    @DisplayName("RPC debug_getBadBlocks")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        DebugGetBadBlocksResponse response = sdk.debug.getBadBlocks().send();
        assertNotNull(response);
        assertNull(response.getError());
    }
}
