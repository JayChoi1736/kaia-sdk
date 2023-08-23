package opensdk.sdk.apis.debug.profiling;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.DebugMutexProfileResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.web3j.protocol.http.HttpService;
@DisplayName("Debug RPC Test")
public class DebugMutexProfileTest {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.RPC));

    @Test
    @DisplayName("RPC debug_mutexProfile")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        String file = "mutex.profile";
        int seconds = 5;

        DebugMutexProfileResponse response = w3.debugMutexProfile(file, seconds).send();

        assertNotNull(response);
        assertNull(response.getError());

        assertNull(response.getResult());
    }
}
