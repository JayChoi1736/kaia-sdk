curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/eth/getTransactionByBlockNumberAndIndex' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "eth_getTransactionByBlockNumberAndIndex",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["0x27", "0x0"]
}'
