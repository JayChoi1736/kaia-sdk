package opensdk.sdk.apis.klay.transaction;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.KlayGetDecodedAnchoringTransactionByHashResponse;
import org.klaytn.OpenSDK;

import java.io.IOException;

public class KlayGetDecodedAnchoringTransactionByHashExample {

    private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);

    void klayGetDecodedAnchoringTransactionByHashExample() throws IOException {
        KlayGetDecodedAnchoringTransactionByHashResponse gr = sdk.klay.getDecodedAnchoringTransactionByHash(
            "0x026b64e16b86633c0199f78f37a64840d3601d83e5c799f115b63024764524ca")
        .send();
        gr.getResult();
    }
}
