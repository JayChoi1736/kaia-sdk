from base.testing import KlaytnBaseTesting


class TestPendingChanges(KlaytnBaseTesting):

    def test_post(self):
        self.response = self.w3.governance.pending_changes()
        self.assertResponseSuccess()
