package opensdk.sdk.apis.personal;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.PersonalLockAccountResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Personal RPC Test")
public class PersonalLockAccountTest {

    private final OpenSDK sdk = new OpenSDK(UrlConstants.SERVER_URL);

    @Test
    @DisplayName("RPC personal_lockAccount")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        PersonalLockAccountResponse response = sdk.personal.lockAccount("0xda04fb00e2cb5745cef7d8c4464378202a1673ef")
                .send();
        assertNotNull(response);
        assertNull(response.getError());
    }
}
