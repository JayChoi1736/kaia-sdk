curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/debug/stopGoTrace' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "debug_stopGoTrace",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
