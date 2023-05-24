from base.testing import KlaytnBaseTesting


class TestSetHead(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.number = "0x100"

    def test_post(self):
        self.response = self.sdk.debug.set_head(
            self.number
        )
        self.assertResponseSuccess()

    def test_post_wrong_with_lack_paramaters(self):
        self.response = self.sdk.debug.set_head()
        self.assertErrorCodeMissingRequiredArgument()
