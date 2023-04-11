import json
from opensdk.sdk import OpenSDK

host = "https://api.baobab.klaytn.net:8651"

sdk = OpenSDK(host)
net_response = sdk.net.peer_count_by_type()

print(json.loads(net_response.response.data))
