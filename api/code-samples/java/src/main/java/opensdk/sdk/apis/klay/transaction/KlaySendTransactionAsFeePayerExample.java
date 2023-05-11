package opensdk.sdk.apis.klay.transaction;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.KlaySendTransactionResponse;
import opensdk.sdk.models.KlaytnTransactionTypes;
import opensdk.sdk.models.Signature;
import org.klaytn.OpenSDK;

import java.io.IOException;
import java.util.List;

public class KlaySendTransactionAsFeePayerExample {
  private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);

  void klaySendTransactionAsFeePayerExample() throws IOException {
    KlaytnTransactionTypes tx = new KlaytnTransactionTypes();
    Signature signature = new Signature();
    signature.setV("0x4e43");
    signature.setR("0xd3ff5ca7bdd0120d79e8aa875593d05022fe74ce2b7a0594218d53c0fdca7fa9");
    signature.setS("0x2c100e69d2455afc9393e017514063da18b18db6f7e811d0aeaf6002515b58ef");
    tx.setTypeInt(18);
    tx.setFrom("0xcd01b2b44584fb143824c1ea0231bebaea826b9d");
    tx.setTo("0x44711E89b0c23845b5B2ed9D3716BA42b8a3e075");
    tx.setGas("0x4a380");
    tx.setGasPrice("0x5d21dba00");
    tx.setNonce("0x2c");
    tx.setValue("0xf4");
    tx.setInput("0xb3f98adc0000000000000000000000000000000000000000000000000000000000000001");
    tx.setFeePayer("0xcd01b2b44584fb143824c1ea0231bebaea826b9d");
    tx.setFeeRatio(30);
    tx.setSignatures(List.of(signature));
    KlaySendTransactionResponse response = sdk.klay.sendTransactionAsFeePayer(tx).send();
    response.getResult();
  }

}
