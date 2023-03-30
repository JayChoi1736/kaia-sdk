const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");

const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('klay_getBlockWithConsensusInfoByNumber API', () => {
    test('should return block info.', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            //console.log('API called successfully. Returned data: ' + JSON.stringify(data));
            done();
        };
        const blockNumber = 1;
        sdk.klay.getBlockWithConsensusInfoByNumber(blockNumber, {}, callbackOne);
    });
});
