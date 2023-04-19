from base.testing import KlaytnBaseTesting


class TestDebugStacks(KlaytnBaseTesting):

    def test_post(self):
        debug_response = self.sdk.debug.stacks()

        self.covert_response(debug_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("result", self.response)
