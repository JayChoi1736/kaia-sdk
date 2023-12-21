const { JsonRpcProvider } = require("@klaytn/ethers-ext");
(() => {
const provider = new JsonRpcProvider("https://public-en-baobab.klaytn.net");

    const address = '0xc94770007dda54cF92009BFF0dE90c06F603a09f'
    const blockNumberOrHashOrTag = 'latest'
    
    provider.eth.getTransactionCount(address, blockNumberOrHashOrTag, {}, (err, data, response) => {
        console.log(data);
    });
}
)()