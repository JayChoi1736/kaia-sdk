package opensdk.sdk.apis.governance;

import opensdk.sdk.apis.constant.UrlConstants;
//import org.web3j.protocol.klaytn.core.method.response.GovernanceItemsAtResponse;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

public class GovernanceItemsAtExample {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.TEST_URL));

    void governanceItemsAtExample() throws IOException {
//        int blockTag = 0;
//
//        GovernanceItemsAtResponse response = w3.governanceItemsAt(blockTag).send();
//        response.getResult();
    }
}
