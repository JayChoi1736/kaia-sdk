package opensdk.sdk.apis.governance;

import opensdk.sdk.apis.constant.UrlConstants;
//import org.web3j.protocol.klaytn.core.method.response.GovernanceGetStakingInfoResponse;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

public class GovernanceGetStakingInfoExample {
    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.TEST_URL));

    void governanceGetStakingInfoExample() throws IOException {
        String blockNum = "latest";

//        GovernanceGetStakingInfoResponse response = w3.governanceGetStakingInfo(blockNum).send();
//        response.getResult();
    }
}
