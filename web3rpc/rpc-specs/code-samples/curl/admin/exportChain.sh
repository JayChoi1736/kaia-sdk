curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/admin/exportChain' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "admin_exportChain",
  "id": 1,
  "jsonrpc": "2.0",
  "params": [
    "/tmp/chain.txt"
  ]
}'
