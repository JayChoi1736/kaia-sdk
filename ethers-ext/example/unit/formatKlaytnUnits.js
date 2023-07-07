const { BigNumber } = require("@ethersproject/bignumber");
const { formatKlaytnUnits, formatKLAY } = require("../../dist/src/core/util"); // require("@klaytn/sdk-ethers");

// 
// https://docs.klaytn.foundation/content/klaytn/design/klaytn-native-coin-klay
// https://docs.ethers.org/v5/api/utils/display-logic/#display-logic--units
//
async function main() {
    const oneGpeb = BigNumber.from("1000000000");
    const oneKLAY = BigNumber.from("1000000000000000000");

    console.log( formatKlaytnUnits(oneGpeb, 0) );
    // '1000000000'

    console.log( formatKlaytnUnits(oneGpeb, "kpeb") );
    // '1000000.0'

    console.log( formatKlaytnUnits(oneGpeb, "Mpeb") );
    // '1000.0'

    console.log( formatKlaytnUnits(oneGpeb, "Gpeb") );
    // '1.0'

    console.log( formatKlaytnUnits(oneGpeb, "ston") );
    // '1.0'

    console.log( formatKlaytnUnits(oneGpeb, 9) );
    // '1.0'

    console.log( formatKlaytnUnits(oneGpeb, "KLAY") );
    // '0.000000001'

    console.log( formatKlaytnUnits(oneKLAY, "KLAY") );
    // '1.0'

    console.log( formatKlaytnUnits(oneKLAY) );
    // '1.0'

    console.log( formatKlaytnUnits(oneKLAY, 18) );
    // '1.0'

    console.log( formatKLAY(oneKLAY) );
    // '1.0'
}

main();