const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");
const { GOVERNANCE_RPC } = require("../constant");

const sdk = new OpenSdk(new OpenSdk.ApiClient(GOVERNANCE_RPC));

describe('governance_myVotingPower API', () => {
    test('should return governance_myVotingPower', (done) => {

        let callbackOne = function (error, data, response) {
            expect(error).toBeNull();
            expect(data).toBeDefined()
            expect(typeof data === 'number').toBe(true)
            done();
        };

        sdk.governance.myVotingPower({}, callbackOne);
    });
});

