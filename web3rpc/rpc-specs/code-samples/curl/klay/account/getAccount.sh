curl -X 'POST' \
  'http://localhost:8551' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "klay_getAccount",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["0x3111a0577f322e8fb54f78d9982a26ae7ca0f722", "latest"]
}'
