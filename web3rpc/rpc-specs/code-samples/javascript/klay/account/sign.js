const { JsonRpcProvider } = require("@klaytn/ethers-ext");
(() => {
let sdk = new JsonRpcProvider("https://public-en-baobab.klaytn.net");

    const address = '0x487f2dfef230c2120b8cc55c5087b103146536ec'
    const message = '0xdeadbeaf'

    sdk.klay.sign(address, message, {}, (err, data, response) => {
        console.log(data);
    });
}
)()