package opensdk.sdk.apis.klay.filter;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.KlayGetLogsResponse;
import org.klaytn.OpenSDK;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.request.Filter;

import java.io.IOException;

public class KlayGetLogsExample {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);

    void klayGetLogsExample() throws IOException {
        Filter<EthFilter> filterOption = new EthFilter(DefaultBlockParameter.valueOf("latest"),DefaultBlockParameter.valueOf("latest")
                ,"0x87ac99835e67168d4f9a40580f8f5c33550ba88b");
        KlayGetLogsResponse response = sdk.klay.getLogs(filterOption).send();
        response.getResult();
    }

}
