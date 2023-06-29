const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");
const { RPC } = require("../../constant");

const sdk = new OpenSdk(new OpenSdk.ApiClient(RPC));

describe('klay_newPendingTransactionFilter API', () => {
    test('should return klay_newPendingTransactionFilter', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data).toBeDefined();
            expect(/^0x[a-f0-9]+/.test(data)).toBe(true);
            done();
        };

        sdk.klay.newPendingTransactionFilter({}, callbackOne);
    });
});