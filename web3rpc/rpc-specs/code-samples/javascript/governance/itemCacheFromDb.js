const { JsonRpcProvider } = require("@klaytn/ethers-ext");
(() => {
const provider = new JsonRpcProvider("https://public-en-baobab.klaytn.net");
    const blockNumber = 0;

    provider.governance.itemCacheFromDb(blockNumber, {}, (err, data, response) => {
        console.log(data);
    });
}
)()