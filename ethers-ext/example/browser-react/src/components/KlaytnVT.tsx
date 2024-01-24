import { useState } from 'react';
import { Account } from '../types';
import { doSendTx } from '../util';
import { TxType, parseKlay } from '@klaytn/js-ext-core';

type Props = {
  account: Account;
};

function KlaytnVT({ account }: Props) {
    const [txhash, setTxhash] = useState<string>("");
    const [error, setError] = useState<any>(null);

    async function handleSubmit(e: any) {
        e.preventDefault();
        const toAddr = e.target.to.value;
        const valuePeb = parseKlay(e.target.amount.value);
        const tx = {
            type: TxType.ValueTransfer, // 0x08
            to: toAddr,
            value: valuePeb,
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
                <p>Type: <input type="text" name="type" value="0x08"></input></p>
                <p>To: <input type="text" name="to" value={account.address}></input></p>
                <p>Value: <input type="text" name="amount" value="0"></input></p>
                <p><input type="submit"></input></p>
            </form>
            { txhash? <a target="_blank" href={txhash} rel="noreferrer">{txhash}</a> : null }
            { error? <text><b style={{ color: "red" }}>{error}</b></text> : null }
        </div>
    );
};

export default KlaytnVT;