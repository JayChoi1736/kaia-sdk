curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/txpool/status' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "txpool_status",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
