const { JsonRpcProvider } = require("@klaytn/ethers-ext");
(() => {
let sdk = new JsonRpcProvider("https://public-en-baobab.klaytn.net");
    sdk.klay.accounts({}, (err, data, response) => {
        console.log(data);
    });
}
)()