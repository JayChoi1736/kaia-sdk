import { Networkish } from "@ethersproject/networks";
import {
  JsonRpcProvider as EthersJsonRpcProvider,
  Web3Provider as EthersWeb3Provider,
  JsonRpcSigner as EthersJsonRpcSigner } from "@ethersproject/providers";
import { ConnectionInfo } from "@ethersproject/web";
import { asyncOpenApi, AsyncNamespaceApi } from "@klaytn/js-ext-core";

// @ts-ignore: package @klaytn/web3rpc has no .d.ts file.
import { AdminApi, DebugApi, GovernanceApi, KlayApi, NetApi, PersonalApi, TxpoolApi } from "@klaytn/web3rpc";

import { JsonRpcSigner as KlaytnJsonRpcSigner } from "./signer";

/* eslint-disable no-multi-spaces */
export class JsonRpcProvider extends EthersJsonRpcProvider {
  // API methods other than eth_ namespaces
  admin:      AsyncNamespaceApi;
  debug:      AsyncNamespaceApi;
  governance: AsyncNamespaceApi;
  klay:       AsyncNamespaceApi;
  net:        AsyncNamespaceApi;
  personal:   AsyncNamespaceApi;
  txpool:     AsyncNamespaceApi;

  constructor(url?: ConnectionInfo | string, network?: Networkish) {
    super(url, network);

    const send = (method: string, params: any) => {
      return this.send(method, params);
    };

    this.admin      = asyncOpenApi(send, AdminApi);
    this.debug      = asyncOpenApi(send, DebugApi);
    this.governance = asyncOpenApi(send, GovernanceApi);
    this.klay       = asyncOpenApi(send, KlayApi);
    this.net        = asyncOpenApi(send, NetApi);
    this.personal   = asyncOpenApi(send, PersonalApi);
    this.txpool     = asyncOpenApi(send, TxpoolApi);
  }
}

const _constructorGuard = {};
export class Web3Provider extends EthersWeb3Provider {
  override getSigner(addressOrIndex?: string | number | undefined): EthersJsonRpcSigner {
    return new KlaytnJsonRpcSigner(this, addressOrIndex);
  }
}