curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/debug/backtraceAt' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "debug_backtraceAt",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["server.go:443"]
}'
