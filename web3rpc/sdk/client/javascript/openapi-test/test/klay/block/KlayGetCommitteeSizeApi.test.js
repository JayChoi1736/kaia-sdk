const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");

const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('klay_getCommitteeSize API', () => {
    test('should return klay_getCommitteeSize', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data).toBeDefined();
            expect(typeof data === 'number').toBe(true);
            done();
        };
        const blockNumberOrTag = '0x1b4'
        sdk.klay.getCommitteeSize({ blockNumberOrTag }, callbackOne);
    });
});
