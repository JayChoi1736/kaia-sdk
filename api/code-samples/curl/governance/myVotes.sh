curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/governance/myVotes' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "governance_myVotes",
  "id": 1,
  "jsonrpc": "2.0",
  "params": []
}'
