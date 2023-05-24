package opensdk.sdk.apis.debug.runtimeTracing;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.DebugGoTraceResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Debug RPC Test")
public class DebugGoTraceTest {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.SERVER_URL);

    @Test
    @DisplayName("RPC debug_goTrace")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        String file = "go.trace";
        int seconds = 5;

        DebugGoTraceResponse response = sdk.debug.goTrace(file, seconds).send();

        assertNotNull(response);
        assertNull(response.getError());
    }
}
