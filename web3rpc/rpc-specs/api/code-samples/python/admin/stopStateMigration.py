from opensdk.sdk import OpenSDK

host = "https://api.baobab.klaytn.net:8651"

sdk = OpenSDK(host)
admin_response = sdk.admin.stop_state_migration()

print(admin_response)
