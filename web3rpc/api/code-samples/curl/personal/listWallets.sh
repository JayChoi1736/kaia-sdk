curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/personal/listWallets' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "personal_listWallets",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
