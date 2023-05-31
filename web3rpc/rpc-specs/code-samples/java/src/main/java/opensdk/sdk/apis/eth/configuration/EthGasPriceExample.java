package opensdk.sdk.apis.eth.configuration;

import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

import java.io.IOException;

public class EthGasPriceExample {

    private Web3j w3 = Web3j.build(new HttpService(UrlConstants.LOCAL_URL));

    void ethGasPriceExample() throws IOException {
        EthGasPrice br = w3.ethGasPrice().send();
        br.getResult();
    }
}
