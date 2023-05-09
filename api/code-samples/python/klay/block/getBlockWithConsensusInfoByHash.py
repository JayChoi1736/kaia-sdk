from opensdk.sdk import OpenSDK

host = "https://api.baobab.klaytn.net:8651"

blockHash = "0xba647d41423faeebe8a7c64737d284fc2eba6f0388a3e1ebf6243db509ec1577"

sdk = OpenSDK(host)
klay_response = sdk.klay.get_block_with_consensus_info_by_hash(blockHash)

print(klay_response)
