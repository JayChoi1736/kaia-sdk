from base.testing import KlaytnBaseTesting


class TestAdminSetMaxSubscriptionPerWSConn(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.limit = 5

    def test_post(self):
        self.response = self.sdk.admin.set_max_subscription_per_ws_conn(
            self.limit
        )
        self.assertResponseSuccess()

    def test_post_wrong_with_lack_paramaters(self):
        self.response = self.sdk.admin.set_max_subscription_per_ws_conn()
        self.assertErrorCodeMissingRequiredArgument()
