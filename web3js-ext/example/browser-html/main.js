var web3 = null;

// https://baobab.klaytnscope.com/account/0xa9eF4a5BfB21e92C06da23Ed79294DaB11F5A6df?tabId=contractCode
var contractAddress = "0xa9eF4a5BfB21e92C06da23Ed79294DaB11F5A6df";
var contractCalldata = "0xd09de08a"; // function increment()

function isKaikas() {
  return web3 && web3.provider.isKaikas;
}

// https://docs.ethers.org/v5/getting-started/#getting-started--connecting
async function connect(injectedProvider) {
  if (!injectedProvider) {
    alert("Please install wallet");
    return;
  }

  // Wrap the window.{ethereum,klaytn} object with Web3.
  if (1) {
    web3 = new Web3(injectedProvider); // from web3@4.3.0/+esm
  } else {
    web3 = new web3_ext.Web3(injectedProvider); // from web3js-ext.bundle.js
  }

  // Detect user network
  const chainId = await web3.eth.getChainId();
  console.log("chainId", chainId);
  $("#textChainId").html(chainId);

  injectedProvider.on("networkChanged", (chainId) => {
    console.log("chainId changed", chainId);
    $("#textChainId").html(chainId);
    web3 = new Web3(injectedProvider);
  });

  // Detect user accounts
  const accounts = await web3.eth.requestAccounts(); // internally eth_accounts
  console.log("accounts", accounts);
  $("#textAccounts").html(accounts);

  injectedProvider.on("accountsChanged", async (accounts) => {
    console.log("accounts changed", accounts);
    $("#textAccounts").html(accounts);
  });
}
async function connectMM() {
  $("text").html(""); // Clear all text
  await connect(window.ethereum);
}
async function connectKK() {
  $("text").html(""); // Clear all text
  await connect(window.klaytn);
}

// https://docs.metamask.io/wallet/how-to/add-network/
// EIP-3085 wallet_addEthereumChain
// EIP-3326 wallet_switchEthereumChain
async function switchNetwork(networkSpec) {
  console.log("switching to", networkSpec);
  try {
    await web3.provider.request({
      method: "wallet_switchEthereumChain",
      params: [{ chainId: networkSpec.chainId }],
    });
  } catch (e) {
    await web3.provider.request({
      method: "wallet_addEthereumChain",
      params: [networkSpec],
    });
  }
}
async function switchBaobab() {
  await switchNetwork({
    chainId: "0x3e9",
    chainName: "Klaytn Baobab",
    nativeCurrency: {
      name: "KLAY",
      symbol: "KLAY",
      decimals: 18,
    },
    rpcUrls: ["https://public-en-baobab.klaytn.net"],
    blockExplorerUrls: ["https://baobab.klaytnscope.com/"],
  });
}

async function signMsg() {
  try {
    if (isKaikas()) {
      const accounts = await web3.eth.getAccounts();
      const message = "Hello dapp";
      const hexMessage = Web3.utils.utf8ToHex(message);

      // Kaikas supports KIP-97 signature via eth_sign
      const signature = await web3.eth.sign(hexMessage, accounts[0]);
      console.log("signature", signature);
      $("#textSignature").html(signature);

      const recoveredAddress = await web3.provider.request({
        method: "klay_recoverFromMessage",
        params: [accounts[0], hexMessage, signature, "latest"]
      });
      console.log("recoveredAddress", recoveredAddress);
      $("#textRecoveredAddress").html(recoveredAddress);
    } else {
      const accounts = await web3.eth.getAccounts();
      const message = "Hello dapp";
      const hexMessage = Web3.utils.utf8ToHex(message);

      // MetaMask supports EIP-191 signature via personal_sign
      const signature = await web3.eth.personal.sign(hexMessage, accounts[0], "");
      console.log("signature", signature);
      $("#textSignature").html(signature);

      const recoveredAddress = web3.eth.accounts.recover(message, signature);
      console.log("recoveredAddress", recoveredAddress);
      $("#textRecoveredAddress").html(recoveredAddress);
    }
  } catch (err) {
    console.error(err);
    $("#textSignature").html(`Error: ${err.message}`);
  }
}

async function doSendTx(makeTxRequest) {
  try {
    const accounts = await web3.eth.getAccounts();
    const txRequest = await makeTxRequest(accounts[0]);

    const receipt = await web3.eth.sendTransaction(txRequest)
      .on("sending", (tx) => console.log("sending", tx));
    console.log("receipt", receipt);
    const txhash = receipt.transactionHash;
    const explorerUrl = "https://baobab.klaytnscope.com/tx/";
    $("#textTxhash").html(`<a href="${explorerUrl}${txhash}" target="_blank">${txhash}</a>`);
  } catch (err) {
    console.error(err);
    $("#textTxhash").html(`Error: ${err.message}`);
  }
}
async function sendLegacyVT() {
  doSendTx(async (address) => {
    return {
      from: address,
      to: address, // send to myself
      value: 0,
    };
  });
}
async function sendLegacySC() {
  doSendTx(async (address) => {
    return {
      from: address,
      to: contractAddress,
      data: contractCalldata,
    };
  });
}
async function sendKlaytnVT() {
  doSendTx(async (address) => {
    return {
      type: ethers_ext.TxType.ValueTransfer, // 0x08
      from: address,
      to: address, // send to myself
      value: 0,
    };
  });
}
async function sendKlaytnSC() {
  doSendTx(async (address) => {
    return {
      type: ethers_ext.TxType.SmartContractExecution, // 0x30
      from: address,
      to: contractAddress,
      data: contractCalldata,
    };
  });
}

// This operation is usually done in the backend by the dApp operator.
// We do it here with hardcoded private key for demonstration purpose.
async function doSendTxAsFeePayer(signedTx) {
  const httpProvider = new ethers_ext.JsonRpcProvider("https://public-en-baobab.klaytn.net");
  const feePayerPriv = "0xb3cf575dea0081563fe5482de2fe4425e025502b1f4ae7e02b2540ac0a5beda1";
  const feePayerWallet = new ethers_ext.Wallet(feePayerPriv, httpProvider);

  const sentTx = await feePayerWallet.sendTransactionAsFeePayer(signedTx);
  console.log("sentTx", sentTx);
  const txhash = sentTx.hash;
  const explorerUrl = "https://baobab.klaytnscope.com/tx/";
  $("#textTxhash").html(`<a href="${explorerUrl}${txhash}" target="_blank">${txhash}</a>`);
}

async function doSignTx(makeTxRequest) {
  try {
    const signer = provider.getSigner();
    const address = await signer.getAddress();
    const txRequest = await makeTxRequest(address);

    const signedTx = await signer.signTransaction(txRequest);
    console.log("signedTx", signedTx);
    $("#textSignedTx").html(`${signedTx}`);

    await doSendTxAsFeePayer(signedTx);
  } catch (err) {
    console.error(err);
    $("#textTxhash").html(`Error: ${err.message}`);
  }
}
async function sendFeeDelegatedVT() {
  doSignTx(async (address) => {
    return {
      type: ethers_ext.TxType.FeeDelegatedValueTransfer, // 0x09
      to: address, // send to myself
      value: 0,
    };
  });
}
async function sendFeeDelegatedSC() {
  doSignTx(async () => {
    return {
      type: ethers_ext.TxType.FeeDelegatedSmartContractExecution, // 0x09
      to: contractAddress,
      data: contractCalldata,
    };
  });
}