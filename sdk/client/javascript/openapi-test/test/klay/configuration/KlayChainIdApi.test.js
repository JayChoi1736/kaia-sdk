const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");

const api = new OpenSdk.KlayConfigurationApi(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('Klay chainId  API', () => {
    test('should return chainId', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            console.log('API called successfully. Returned data: ' + JSON.stringify(data));
            done();
        };
        api.chainID({}, callbackOne);
    });
});
