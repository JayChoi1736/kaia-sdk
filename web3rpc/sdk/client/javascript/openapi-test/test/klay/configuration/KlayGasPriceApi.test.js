const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");

const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('Klay gasPrice  API', () => {
    test('should return gas price.', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data).toBeDefined();
            expect(typeof data === 'string' && /^0x[a-fA-F0-9]+/.test(data)).toBe(true);
            done();
        };
        sdk.klay.gasPrice({}, callbackOne);
    });
});
