from base.testing import KlaytnBaseTesting


class TestStartCollectingTrieStats(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.address = "0xa94f5374fce5edbc8e2a8697c15331677e6ebf0b"

    def test_post(self):
        debug_response = self.sdk.debug.start_collecting_trie_stats(
            self.address
        )

        self.covert_response(debug_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("result", self.response)

    def test_post_wrong_with_lack_paramaters(self):
        debug_response = self.sdk.debug.start_collecting_trie_stats()

        self.covert_response(debug_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("error", self.response)
        self.assertErrorCodeMissingRequiredArgument()
