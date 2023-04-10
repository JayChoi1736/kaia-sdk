from base.testing import KlaytnBaseTesting


class TestEthHashRate(KlaytnBaseTesting):

    def test_post(self):
        eth_response = self.sdk.eth.hash_rate()

        self.covert_response(eth_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("result", self.response)
