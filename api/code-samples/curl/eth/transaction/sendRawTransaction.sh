curl -X 'POST' \
  'https://api.baobab.klaytn.net:8651/eth/sendRawTransaction' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "method": "eth_sendRawTransaction",
  "id": 1,
  "jsonrpc": "2.0",
  "params": ["0xaca5d9a1ed8b86b1ef61431b2bedfc99a66eaefc3a7e1cffdf9ff53653956a67"]
}'
