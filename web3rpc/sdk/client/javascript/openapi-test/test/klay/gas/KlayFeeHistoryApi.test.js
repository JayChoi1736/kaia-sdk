const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");
const { BAOBAB_RPC } = require("../../constant");

const sdk = new OpenSdk(new OpenSdk.ApiClient(BAOBAB_RPC));

describe('Klay feeHistory API', () => {
    test('should return fee information', (done) => {
        let callbackOne = function (error, data, response) {
            expect(error).toBeNull();
            expect(data).toBeDefined();
            expect(data.oldestBlock).toBeDefined()
            expect(data.oldestBlock).toMatch(/^0x.*$/)
            done();
        };
        const blockCount = '0x10'
        const lastBlock = 'latest'
        const rewardPercentiles = [0.1, 0.2, 0.3]
        sdk.klay.feeHistory(blockCount, lastBlock, rewardPercentiles, {}, callbackOne);
    });
});
