const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");

const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('Klay getBlockRecepts API', () => {
    test('should return block receipts.', (done) => {

        let callbackOne = function (error, data, response) {
            
            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            console.log('API called successfully. Returned data: ' + JSON.stringify(data));
            done();
        };
        const blockHash = '0xba647d41423faeebe8a7c64737d284fc2eba6f0388a3e1ebf6243db509ec1577'
        sdk.klay.getBlockReceipts(blockHash, {},callbackOne);
    });
});
