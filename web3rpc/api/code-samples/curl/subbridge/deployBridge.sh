curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/subbridge/deployBridge' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "subbridge_deployBridge",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
