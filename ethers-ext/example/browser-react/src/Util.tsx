import { JsonRpcProvider, Wallet } from '@klaytn/ethers-ext'
import { Account } from "./types";

const explorerUrl = "https://baobab.klaytnscope.com/tx/";

export function isKaikas(account: Account) {
    // @ts-ignore
    return account.provider && account.provider.provider.isKaikas;
  }

export async function doSendTx(account: Account, makeTxRequest: any) {
    try {
        const provider = account.provider;
        // @ts-ignore
        const signer = provider.getSigner();
        const address = await signer.getAddress();
        const txRequest = await makeTxRequest(address);
        const sentTx = await signer.sendTransaction(txRequest);
        
        return explorerUrl+sentTx.hash;
    } catch (err) {
        console.error(err);
    }
}

// This operation is usually done in the backend by the dApp operator.
// We do it here with hardcoded private key for demonstration purpose.
async function doSendTxAsFeePayer(signedTx: string) {
    try {
        const httpProvider = new JsonRpcProvider("https://public-en-baobab.klaytn.net");
        const feePayerPriv = "0x9435261ed483b6efa3886d6ad9f64c12078a0e28d8d80715c773e16fc000cff4";
        const feePayerWallet = new Wallet(feePayerPriv, httpProvider);
    
        const sentTx = await feePayerWallet.sendTransactionAsFeePayer(signedTx);
        console.log("sentTx", sentTx);
        
        return explorerUrl+sentTx.hash;
    } catch (err) {
        console.error(err);
    }
}


export async function doSignTx(account: Account, makeTxRequest: any) {
    try {
        debugger
      const signer = account.provider?.getSigner();
      // @ts-ignore
      const address = await signer.getAddress();
      const txRequest = await makeTxRequest(address);
      // @ts-ignore
      const signedTx = await signer.signTransaction(txRequest);
      console.log("signedTx", signedTx);
      
      return await doSendTxAsFeePayer(signedTx);
    } catch (err) {
      console.error(err);
    }
}