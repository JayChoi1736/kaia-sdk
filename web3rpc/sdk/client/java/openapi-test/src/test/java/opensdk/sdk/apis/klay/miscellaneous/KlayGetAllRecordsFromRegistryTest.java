package opensdk.sdk.apis.klay.miscellaneous;

import opensdk.sdk.apis.constant.UrlConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.klaytn.Web3j;
import org.web3j.protocol.klaytn.core.method.response.KlayGetAllRecordsFromRegistryResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Klay getBlsInfos Test")
public class KlayGetAllRecordsFromRegistryTest {
	final Web3j w3 = Web3j.build(new HttpService("http://3.39.84.202:8651/"));

	@Test
	@DisplayName("RPC klay_getBlsInfos")
	void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
		String blockNumber = "latest";
		KlayGetAllRecordsFromRegistryResponse response = w3.klayGetAllRecordsFromRegistry ("KIP113",blockNumber).send();

		assertNotNull(response);
		assertNull(response.getError());
	}
}
