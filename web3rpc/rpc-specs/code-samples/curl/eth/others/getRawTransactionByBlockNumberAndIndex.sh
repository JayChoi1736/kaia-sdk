curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/eth/getRawTransactionByBlockNumberAndIndex' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "eth_getRawTransactionByBlockNumberAndIndex",
  "id": 1,
  "jsonrpc": "2.0",
  "params": [118593751, "0x0"]
}'
