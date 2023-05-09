from base.testing import KlaytnBaseTesting
from base.klay import create_new_filter


class TestGetFilterLogs(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.quantity = create_new_filter()

    def test_post(self):
        self.response = self.sdk.klay.get_filter_logs(
            self.quantity
        )
        self.assertResponseSuccess()

    def test_post_wrong_with_lack_paramaters(self):
        self.response = self.sdk.klay.get_filter_logs()
        self.assertErrorCodeMissingRequiredArgument()
