from base.testing import KlaytnBaseTesting


class TestTraceBadBlock(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.blockHash = "0x1d5ba00e313a81ae6d409d459c153327072665d9ea2f47608369722baf0cfbb6"

    def test_post(self):
        self.response = self.w3.debug.trace_bad_block(
            self.blockHash
        )
        if self.response is not None:
            self.assertIsInstance(self.response["gas"], int)
        else:
            self.assertIsNone(self.response)

    def test_post_wrong_with_lack_paramaters(self):
        with self.assertRaises(ValueError):
            self.response = self.w3.debug.trace_bad_block()

