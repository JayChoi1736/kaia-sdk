curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/debug/blockProfile' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "debug_setVMLogTarget",
  "id": 1,
  "jsonrpc": "2.0",
  "params": [3]
}'
