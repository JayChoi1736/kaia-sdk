curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/admin/peers' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "admin_peers",
  "id": 1,
  "jsonrpc": "2.0"
}'
