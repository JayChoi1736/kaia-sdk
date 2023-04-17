const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");
const { RPC } = require("../constant");

const sdk = new OpenSdk(new OpenSdk.ApiClient(RPC));

describe('admin_exportChain API', () => {
    test('should return admin_exportChain', (done) => {

        let callbackOne = function (error, data, response) {
            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            done();
        };
        const fileName = `/tmp/chain-${Date.now()}.txt`
        sdk.admin.exportChain(fileName, {}, callbackOne);
    });
});
