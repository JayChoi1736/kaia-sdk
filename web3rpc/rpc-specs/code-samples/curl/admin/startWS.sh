curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/admin/startWS' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "admin_startWS",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["127.0.0.1", 8552, "", "klay"]
}'
