from base.testing import KlaytnBaseTesting


class TestDebugGetModifiedAccountsByNumber(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.startBlockNum = 171904
        self.endBlockNum = 172160

    def test_post(self):
        self.response = self.sdk.debug.get_modified_accounts_by_number(
            self.startBlockNum, self.endBlockNum
        )
        self.assertResponseSuccess()

    def test_post_wrong_with_lack_paramaters(self):
        self.response = self.sdk.debug.get_modified_accounts_by_number()
        self.assertErrorCodeMissingRequiredArgument()
