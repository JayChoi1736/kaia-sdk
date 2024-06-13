curl -X 'POST' \
  'http://localhost:8551' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "eth_getUncleByBlockNumberAndIndex",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["0xe8", "0x1"]
}'
