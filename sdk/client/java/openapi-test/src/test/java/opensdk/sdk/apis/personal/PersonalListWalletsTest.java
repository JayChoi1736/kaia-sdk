package opensdk.sdk.apis.personal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.PersonalListWalletsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

@DisplayName("Personal RPC Test")
public class PersonalListWalletsTest {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.SERVER_URL);

    @Test
    @DisplayName("RPC personal_listAccounts")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        PersonalListWalletsResponse response = sdk.personal.listWallets()
                .send();
        assertNotNull(response);
        assertNull(response.getError());
    }
}
