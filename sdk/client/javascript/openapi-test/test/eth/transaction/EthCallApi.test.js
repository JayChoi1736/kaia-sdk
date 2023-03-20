const OpenSdk = require("opensdk-javascript");
const { expect } = require("@jest/globals");

const api = new OpenSdk.EthTransactionApi(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));

describe('Eth transaction call API', () => {
    test('should return result', (done) => {

        let callbackOne = function (error, data, response) {

            expect(error).toBeNull();
            expect(data.jsonrpc).toBe("2.0");
            expect(data.result).toBeDefined()
            console.log('API called successfully. Returned data: ' + JSON.stringify(data));
            done();
        };
        const callObject = {"from": "0xca7a99380131e6c76cfa622396347107aeedca2d", "to": "0xbE3892d33620bE5aca8c75D39e7401871194d290", "input": "0x2e64cec1"}
        const blockTag = 'latest'
        const stateOverrideSet = { "0xbE3892d33620bE5aca8c75D39e7401871194d290": 
        { "code": "0x6080604052600436106049576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632e64cec114604e5780636057361d146076575b600080fd5b348015605957600080fd5b50606060a0565b6040518082815260200191505060405180910390f35b348015608157600080fd5b50609e6004803603810190808035906020019092919050505060a9565b005b60008054905090565b80600081905550505600a165627a7a723058207783dba41884f73679e167576362b7277f88458815141651f48ca38c25b498f80029" } }
        api.ethCall(callObject, blockTag, stateOverrideSet, {}, callbackOne);
    });
});
