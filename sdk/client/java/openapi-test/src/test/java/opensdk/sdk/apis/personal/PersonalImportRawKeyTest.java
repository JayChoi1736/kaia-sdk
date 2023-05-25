package opensdk.sdk.apis.personal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.PersonalImportRawKeyResponse;
import opensdk.sdk.utils.CommonUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

@DisplayName("Personal RPC Test")
public class PersonalImportRawKeyTest {

    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.SERVER_URL));

    @Test
    @DisplayName("RPC personal_importRawKey")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        String rawKey = CommonUtils.genHexString();

        PersonalImportRawKeyResponse response = w3.personalImportRawKey(rawKey, "mypassword").send();
        assertNotNull(response);
        assertNull(response.getError());
    }
}
