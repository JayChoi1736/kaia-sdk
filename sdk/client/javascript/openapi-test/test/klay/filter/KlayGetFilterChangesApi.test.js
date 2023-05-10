const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");
const { getKlayFilterId } = require("../../../helpers/klay");
const { BAOBAB_RPC } = require('../../constant')
const sdk = new OpenSdk(new OpenSdk.ApiClient(BAOBAB_RPC));

describe('klay_getFilterChanges API', () => {
    test('should return klay_getFilterChanges', (done) => {

        let callbackOne = function (error, data, response) {
            expect(error).toBeNull();
            expect(data).toBeDefined()
            done();
        };
        getKlayFilterId().then(quantity => {

            sdk.klay.getFilterChanges(quantity, {}, callbackOne);

        })

    });
});
