curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/governance/chainConfig' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "governance_chainConfig",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
