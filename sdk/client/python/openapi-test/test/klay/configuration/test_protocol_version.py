from base.testing import KlaytnBaseTesting


class TestProtocolVersion(KlaytnBaseTesting):

    def test_post(self):
        klay_response = self.sdk.klay.protocol_version()

        self.covert_response(klay_response.response)
        self.assertResponseSuccess()
        self.assertIn("result", self.response)
