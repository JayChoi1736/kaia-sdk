from base.testing import KlaytnBaseTesting
import re


class TestKlayGetBlockByNumber(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.blockTag = "0x64"
        self.boolean = True

    def test_post(self):
        self.response = self.sdk.klay.get_block_by_number(
            self.blockTag, self.boolean
        )
        self.assertResponseSuccess()
        self.assertTrue(re.match(r"^0x?", self.response["hash"]))

    def test_post_wrong_with_lack_paramaters(self):
        self.response = self.sdk.klay.get_block_by_number(self.blockTag)
        self.assertErrorCodeMissingRequiredArgument()
