const OpenSdk = require("opensdk-javascript");

(() => {
    const sdk = new OpenSdk(new OpenSdk.ApiClient("https://api.baobab.klaytn.net:8651"));


    const blockNumberOrHash = 'latest'
    sdk.eth.createAccessList(transactionArgs, { blockNumberOrHash }, (err, data, response) => {
        console.log(data);
    });

}
)()