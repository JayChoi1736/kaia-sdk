import _ from "lodash";
import { JsonRpcProvider as EthersJsonRpcProvider } from "@ethersproject/providers";
import { ConnectionInfo } from "@ethersproject/web";
import { Networkish } from "@ethersproject/networks";

// @ts-ignore: package @klaytn/web3rpc has no .d.ts file.
import { ApiClient, KlayApi } from "@klaytn/web3rpc";

export class JsonRpcProvider extends EthersJsonRpcProvider {

  openApiClient: any;

  constructor(url?: ConnectionInfo | string, network?: Networkish) {
    super(url, network);

    this.openApiClient = makeApiClient(url);
  }

  get klay(): any {
    return new KlayApi(this.openApiClient);
  }
}

// Make OpenAPI-Generator ApiClient from ConnectionInfo
function makeApiClient(url?: ConnectionInfo | string): any {
  if (_.isString(url)) {
    return new ApiClient(url);
  }

  // Transplant ethers ConnectionInfo settings to OpenAPI ApiClient settings.
  // Some ConnectionInfo settings are sliently ignored.
  // See https://github.com/ethers-io/ethers.js/blob/v5/packages/web/src.ts/index.ts#L97:_fetchData
  // See https://github.com/klaytn/web3klaytn/blob/dev/web3rpc/sdk/client/javascript/template/libraries/javascript/ApiClient.mustache
  let conn = url as ConnectionInfo;
  let client = new ApiClient(conn.url);

  if (conn.user && conn.password) {
    client.authentications = {
      "basic": {
        username: conn.user,
        password: conn.password,
      }
    };
  }
  if (_.isNumber(conn.timeout)) {
    // Both timeouts are in milliseconds.
    client.timeout = conn.timeout;
  }
  if (conn.headers) {
    _.forOwn(conn.headers, (value, key) => {
      client.defaultHeaders[key] = value;
    });
  }

  return client;
}
