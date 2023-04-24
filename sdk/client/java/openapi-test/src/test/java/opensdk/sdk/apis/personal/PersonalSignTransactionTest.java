package opensdk.sdk.apis.personal;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.PersonalSignTransactionResponse;
import opensdk.sdk.models.TransactionObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;

@DisplayName("Personal RPC Test")
public class PersonalSignTransactionTest {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.SERVER_URL);

    @Test
    @DisplayName("RPC personal_signTransaction")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        TransactionObject transactionObject = new TransactionObject();
        transactionObject.setFrom("0x413ba0e5f6f00664598b5c80042b1308f4ff1408");
        transactionObject.setTo("0x8c9f4468ae04fb3d79c80f6eacf0e4e1dd21deee");
        transactionObject.setValue("0x1");
        transactionObject.setGas("0x9999");
        transactionObject.setNonce("0x1");
        transactionObject.setGasPrice("0x25000000000");

        String password = "helloWorld";

        PersonalSignTransactionResponse response = sdk.personal.signTransaction(transactionObject, password).send();
        response.getResult();
    }
}
