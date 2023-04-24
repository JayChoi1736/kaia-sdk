import json
from opensdk.sdk import OpenSDK

host = "https://api.baobab.klaytn.net:8651"

tx = {
    "from": "0x413ba0e5f6f00664598b5c80042b1308f4ff1408",
    "to": "0x8c9f4468ae04fb3d79c80f6eacf0e4e1dd21deee",
    "value": "0x1"
}
passphrase = "helloWorld"

sdk = OpenSDK(host)
personal_response = sdk.personal.send_transaction(tx, passphrase)

print(json.loads(personal_response.response.data))
