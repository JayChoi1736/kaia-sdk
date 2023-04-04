from base.testing import KlaytnBaseTesting


class TestCreateAccessList(KlaytnBaseTesting):

    def setUp(self) -> None:
        self.callObject = {
            "from": "0x3bc5885c2941c5cda454bdb4a8c88aa7f248e312",
            "to": "0x00f5f5f3a25f142fafd0af24a754fafa340f32c7",
            "gas": "0x3d0900",
            "gasPrice": "0x3b9aca00",
            "data": "0x20965255"
        }
        self.blockTag = "latest"

    def test_post(self):
        klay_response = self.sdk.klay.create_access_list(
            self.callObject, self.blockTag
        )

        self.covert_response(klay_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("result", self.response)

    def test_post_wrong_with_lack_paramaters(self):
        klay_response = self.sdk.klay.create_access_list()

        self.covert_response(klay_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("error", self.response)
        self.assertErrorCodeMissingRequiredArgument()
