import Web3, {Bytes, Transaction, Web3Context} from "web3";
import { signTransaction, SignTransactionResult, privateKeyToAddress, Web3Account } from "web3-eth-accounts";
import { bytesToHex } from "web3-utils";
import { DataFormat, DEFAULT_RETURN_FORMAT } from "web3-types";
import { SendTransactionOptions } from "web3-eth";
import _ from "lodash";

import { prepareTransaction } from "./klaytn_tx";
import { klay_sendSignedTransaction } from "./send_transaction";
import { privateKeyToAccount, signTransactionAsFeePayer } from "./account";

// TODO: Change the path after web3-core deployed
const { objectFromRLP } = require("../../../../ethers-ext/dist/src");

export class KlaytnWeb3 extends Web3 {
  constructor(provider: any) {
    // TODO: Override default values to fit Klaytn network.
    // transactionSendTimeout = 50*1000

    // The Web3 constructor. See web3/src/web3.ts
    super(provider);

    // Override web3.eth.accounts. See web3/src/accounts.ts:initAccountsForContext
    // The functions are bound to 'this' object.
    // TODO: override more web3.eth.accounts methods
    this.eth.accounts.privateKeyToAccount = this.accounts_privateKeyToAccount(this);
    this.eth.accounts.signTransaction = this.accounts_signTransaction(this);

    // New added function for Klaytn
    // @ts-ignore 
    this.eth.accounts.signTransactionAsFeePayer = this.accounts_signTransactionAsFeePayer(this);

    // Override web3.eth RPC method wrappers. See web3-eth/src/web3_eth.ts:Web3Eth
    // Note that web3.eth methods should simply call eth_ RPCs to Klaytn node,
    // except a few methods below which call klay_ RPCs despite its name 'web3.eth'.
    this.eth.getProtocolVersion = this.eth_getProtocolVersion(this);
    this.eth.sendSignedTransaction = this.eth_sendSignedTransaction(this);

    
    // TODO: Connect web3.klay, web3.net, etc from @klaytn/web3rpc

  }

  // Below methods return a function bound to the context 'web3'.

  accounts_privateKeyToAccount(context: Web3Context): typeof this.eth.accounts.privateKeyToAccount {

    return (privateKey: Bytes, ignoreLength?: boolean): Web3Account => {
      return privateKeyToAccount(context, privateKey, ignoreLength);
    }; 
  }


  accounts_signTransaction(context: Web3Context): typeof this.eth.accounts.signTransaction {
    // signTransactionWithContext. see web3/src/accounts.ts:initAccountsForContext
    return async (transaction: Transaction, privateKey: Bytes): Promise<SignTransactionResult> => {
      let tx = await prepareTransaction(transaction, context, privateKey);
      let priv = bytesToHex(privateKey);
      return signTransaction(tx, priv);
    };
  }

  accounts_signTransactionAsFeePayer(context: Web3Context): typeof this.eth.accounts.signTransaction {
    // signTransactionWithContext. see web3/src/accounts.ts:initAccountsForContext
    return async (transaction: any, privateKey: Bytes): Promise<any> => {
      let tx; 

      if (typeof transaction === "string") {
        if (Web3.utils.isHex(transaction)) {
          tx = objectFromRLP(transaction);
        } else {
          throw new Error("String type input has to be RLP encoded Hex string.");
        }
      } else {
        tx = transaction;
      }

      if (!tx.feePayer) {
        tx.feePayer = privateKeyToAddress(privateKey);
      }

      let ftx = await prepareTransaction(tx, context, privateKey);      
      let priv = bytesToHex(privateKey);
      return signTransactionAsFeePayer(ftx, priv);
    };
  }

  eth_getProtocolVersion(context: Web3Context): typeof this.eth.getProtocolVersion {
    // See web3-eth/src/web3_eth.ts:Web3Eth
    // See web3-rpc-methods/src/eth_rpc_methods.ts
    return async (): Promise<string> => {
      return context.requestManager.send({
        method: "klay_protocolVersion",
        params: [],
      })
    }
  }

  eth_sendSignedTransaction(context: Web3Context): typeof this.eth.sendSignedTransaction {
    // See web3-eth/src/web3_eth.ts:Web3Eth
    // @ts-ignore: TODO: fix typing
    return async<ReturnFormat extends DataFormat = typeof DEFAULT_RETURN_FORMAT> (
      transaction: Bytes,
      returnFormat: ReturnFormat = DEFAULT_RETURN_FORMAT as ReturnFormat,
      options?: SendTransactionOptions) => {
        // TODO: use klay_sendRawTransaction
        return klay_sendSignedTransaction(context, transaction, returnFormat, options)
      }
  }
}
