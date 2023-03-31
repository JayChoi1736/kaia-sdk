import json
from opensdk.sdk import OpenSDK

host = "https://api.baobab.klaytn.net:8651"

blogTag = "0x27"
transactionIndex = "0x0"

sdk = OpenSDK(host)
klay_response = sdk.klay.get_raw_transaction_by_block_number_and_index(blogTag, transactionIndex)

print(json.loads(klay_response.response.data))