curl -X 'POST' \
  'http://localhost:8551' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "admin_stopHTTP",
  "id": 1,
  "jsonrpc": "2.0"
}'
