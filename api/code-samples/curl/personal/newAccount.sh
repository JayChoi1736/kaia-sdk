curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/personal/newAccount' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "personal_newAccount",
  "id": 1,
  "jsonrpc": "2.0",
  "params": [
    "helloWorld",
  ]
}'
