package opensdk.sdk.apis.klay.transaction;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.KlaySignTransactionResponse;
import opensdk.sdk.models.KlaytnTransactionTypes;
import org.klaytn.OpenSDK;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class KlaySignTransactionExample {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);
    void klaySignTransactionExample() throws IOException, ExecutionException, InterruptedException {
        KlaytnTransactionTypes type = new KlaytnTransactionTypes();
        String address = "0x487f2dfef230c2120b8cc55c5087b103146536ec";
        String nonce = "0x20";
        type.setFrom(address);
        type.setTo("0x8c9f4468ae04fb3d79c80f6eacf0e4e1dd21deee");
        type.setValue("0x10000");
        type.setGas("0x1000000");
        type.setGasPrice("0x25000000000");
        type.setNonce(nonce);
        KlaySignTransactionResponse response = sdk.klay.signTransaction(type).send();

    }
    
}
