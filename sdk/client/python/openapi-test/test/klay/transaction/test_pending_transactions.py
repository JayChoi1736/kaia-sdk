from base.testing import KlaytnBaseTesting


class TestPendingTransactions(KlaytnBaseTesting):

    def test_post(self):
        klay_response = self.sdk.klay.pending_transactions()

        self.covert_response(klay_response.response)
        self.assertResponseSuccess()
        self.assertIn("result", self.response)
