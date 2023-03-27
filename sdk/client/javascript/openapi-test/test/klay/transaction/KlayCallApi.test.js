const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");


const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));
describe('Eth transaction call API', () => {
    test('should return result', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            console.log('API called successfully. Returned data: ' + JSON.stringify(data));
            done();
        };
        const callObject = {
            "from": "0x3f71029af4e252b25b9ab999f77182f0cd3bc085",
            "to": "0x87ac99835e67168d4f9a40580f8f5c33550ba88b",
            "gas": "0x100000",
            "gasPrice": "0x5d21dba00",
            "value": "0x0",
            "input": "0x8ada066e"
          }
        const blockTag = 'latest'
        sdk.klay.call(callObject, blockTag, {}, callbackOne);
    },50000);
});
