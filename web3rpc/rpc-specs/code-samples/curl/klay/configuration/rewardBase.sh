curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/klay/rewardbase' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "klay_rewardbase",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
