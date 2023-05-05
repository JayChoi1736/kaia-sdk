const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");
const { RPC } = require("../../constant");

const sdk = new OpenSdk(new OpenSdk.ApiClient(RPC));

describe('eth_protocolVersion API', () => {
    test('should return eth_protocolVersion', (done) => {

        let callbackOne =  function (error, data, response) {
            
            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            done();
        };
       
        sdk.eth.protocolVersion({}, callbackOne);
    });
});