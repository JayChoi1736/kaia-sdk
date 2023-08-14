package opensdk.sdk.apis.governance;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;
import org.web3j.protocol.klaytn.core.method.response.GovernanceGetRewardsAccumulatedResponse;

import java.io.IOException;

public class GovernanceGetRewardsAccumulatedExample {
    private Web3j w3 = new Web3j(new HttpService(UrlConstants.TEST_URL));

    void governanceGetRewardsAccumulatedExample() throws IOException {
        int firstBlock = 123400489;
        int lastBlock = 123416489;
        GovernanceGetRewardsAccumulatedResponse response = w3.governanceGetRewardsAccumulated(firstBlock, lastBlock).send();
        response.getResult();
    }
}
