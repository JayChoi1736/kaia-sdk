curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/klay/nodeAddress' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "klay_nodeAddress",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
