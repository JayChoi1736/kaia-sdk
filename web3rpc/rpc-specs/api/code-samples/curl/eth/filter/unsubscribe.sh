curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/eth/unsubscribe' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "eth_unsubscribe",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["0xab8ac7a4045025d0c2807d63060eea6d"]
}'
