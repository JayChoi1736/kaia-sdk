from opensdk.sdk import OpenSDK

host = "https://api.baobab.klaytn.net:8651"

blockHash = "0xb8deae63002d2b6aa33247c8ef545383ee0fd2282ac9b49dbbb74114389ddb5c"
uncleIndex = "0x1"

sdk = OpenSDK(host)
eth_response = sdk.eth.get_uncle_by_block_hash_and_index(blockHash, uncleIndex)

print(eth_response)
