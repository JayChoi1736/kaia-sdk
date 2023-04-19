from base.testing import KlaytnBaseTesting


class TestAdminStartStateMigration(KlaytnBaseTesting):

    def test_post(self):
        admin_response = self.sdk.admin.start_state_migration()

        self.covert_response(admin_response.response)
        self.assertResponseSuccess()
        self.assertIn("jsonrpc", self.response)
        self.assertIn("id", self.response)
        self.assertIn("result", self.response)
