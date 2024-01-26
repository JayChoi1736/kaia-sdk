import { useState } from 'react';
import { Account } from '../types';
import { doSendTx } from '../util';
import { TxType } from '@klaytn/js-ext-core';

type Props = {
  account: Account;
};

// https://baobab.klaytnscope.com/account/0xa9eF4a5BfB21e92C06da23Ed79294DaB11F5A6df?tabId=contractCode
var contractAddress = "0xa9eF4a5BfB21e92C06da23Ed79294DaB11F5A6df";
var contractCalldata = "0xd09de08a"; // function increment()

function KlaytnSC({ account }: Props) {
    const [txhash, setTxhash] = useState<string>("");
    const [error, setError] = useState<any>(null);

    async function handleSubmit(e: any) {
        e.preventDefault();
        const tx = {
            type: TxType.SmartContractExecution, // 0x30
            to: contractAddress,
            data: contractCalldata,
        };

        try {
            const txhash = await doSendTx(account, tx);
            setTxhash(txhash);
        } catch (e: any) {
            setError(e);
        }
    }

    return (
        <div className="menu-component"> 
            <form onSubmit={handleSubmit}>
                <p>Type: <input type="text" name="type" value="0x30"></input></p>
                <p>To: <input type="text" name="to" value={contractAddress}></input></p>
                <p>Data: <input type="text" name="data" value={contractCalldata}></input></p>
                <p><input type="submit"></input></p>
            </form>
            { txhash? <a target="_blank" href={txhash} rel="noreferrer">{txhash}</a> : null }
            { error? <text><b style={{ color: "red" }}>{error}</b></text> : null }
        </div>
    );
};

export default KlaytnSC;