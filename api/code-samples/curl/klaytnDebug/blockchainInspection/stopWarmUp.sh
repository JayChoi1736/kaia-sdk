curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/debug/stopWarmUp' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "debug_stopWarmUp",
  "id": 1,
  "jsonrpc": "2.0"
}'
