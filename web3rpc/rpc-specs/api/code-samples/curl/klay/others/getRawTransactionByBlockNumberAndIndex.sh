curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/klay/getRawTransactionByBlockNumberAndIndex' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "klay_getRawTransactionByBlockNumberAndIndex",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["0x27", "0x0"]
}'
