const OpenSdk = require("opensdk-javascript");
const {expect} = require("@jest/globals");

const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('Klay account API', () => {
    test('should return false for Not_Found', (done) => {
        
        let callbackOne = function (error, data, response) {
            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            done();
        };
        sdk.klay.accounts({}, callbackOne);
    });
});
