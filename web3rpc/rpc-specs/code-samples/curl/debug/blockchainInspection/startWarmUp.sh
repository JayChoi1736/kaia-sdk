curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/debug/startWarmUp' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "debug_startWarmUp",
  "id": 1,
  "jsonrpc": "2.0"
}'
