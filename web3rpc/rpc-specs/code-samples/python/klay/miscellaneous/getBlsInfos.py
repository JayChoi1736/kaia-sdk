from web3 import Web3
from web3py_ext import extend

host = "https://api.baobab.klaytn.net:8651"

blockNumber = 'latest'

w3 = Web3(Web3.HTTPProvider(host))
klay_response = w3.klay.get_bls_infos(blockNumber)

print(klay_response)
