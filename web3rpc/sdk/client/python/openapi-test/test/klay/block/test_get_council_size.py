from base.testing import KlaytnBaseTesting


class TestKlayGetCouncilSize(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.blockTag = "0x1b4"

    def test_post(self):
        self.response = self.sdk.klay.get_council_size(
            self.blockTag
        )
        self.assertResponseSuccess()
