package org.web3j.protocol.klaytn.core.klay.others;

import java.io.IOException;
import opensdk.sdk.apis.constant.UrlConstants;
import org.web3j.protocol.klaytn.core.method.response.KlayResendResponse;
import org.web3j.protocol.klaytn.core.method.response.TransactionArgs;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;

public class KlayResendExample {
  private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);
  void klayResendExample() throws IOException {
    TransactionArgs sendArgs = new TransactionArgs();
    sendArgs.setFrom("0x65b47be3457ff26f2911cf89fd079cef0475a2e6");
    sendArgs.setTo("0x8c9f4468ae04fb3d79c80f6eacf0e4e1dd21deee");
    sendArgs.setValue("0x1");
    sendArgs.setGas("0x9999");
    sendArgs.setNonce("0xd");
    sendArgs.setMaxPriorityFeePerGas("0x5d21dba00");
    sendArgs.setMaxFeePerGas("0x5d21dba00");
    String gasPrice = "0xba43b7500";
    String gasLimit = "0xe8d4a50fff";
    KlayResendResponse response = sdk.klay.resend(sendArgs, gasPrice, gasLimit).send();
    response.getResult();

  }
}
