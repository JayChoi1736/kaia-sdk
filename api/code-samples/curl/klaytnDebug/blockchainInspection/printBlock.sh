curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/debug/printBlock' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "debug_printBlock",
  "id": 1,
  "jsonrpc": "2.0",
  "params": [65120]
}'
