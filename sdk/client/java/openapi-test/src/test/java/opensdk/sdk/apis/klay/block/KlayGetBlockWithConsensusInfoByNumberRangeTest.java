package opensdk.sdk.apis.klay.block;

import opensdk.sdk.apis.constant.UrlConstants;
import opensdk.sdk.models.KlayGetBlockWithConsensusInfoByNumberRangeResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.klaytn.OpenSDK;

import java.io.IOException;


public class KlayGetBlockWithConsensusInfoByNumberRangeTest {
    private final OpenSDK sdk = new OpenSDK(UrlConstants.TEST_URL);

    @Test
    @DisplayName("RPC klay_getBlockWithConsensusInfoByNumberRange")
    void whenRequestValid_ThenCall200ResponseReturns() throws IOException {
        Integer blockNumber = 1;
        Integer numberRange = 1;
        KlayGetBlockWithConsensusInfoByNumberRangeResponse response = sdk.klay
                .getBlockWithConsensusInfoByNumberRange(blockNumber , numberRange).send();
        response.getResult();
    }
}
