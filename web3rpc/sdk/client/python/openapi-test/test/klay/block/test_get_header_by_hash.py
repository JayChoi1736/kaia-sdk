from base.testing import KlaytnBaseTesting
import re


class TestKlayGetHeaderByHash(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.blockHash = "0xba647d41423faeebe8a7c64737d284fc2eba6f0388a3e1ebf6243db509ec1577"

    def test_post(self):
        self.response = self.w3.klay.get_header_by_hash(
            self.blockHash
        )
        self.assertResponseSuccess()
        self.assertTrue(re.match(r"^0x?", self.response["hash"]))

    def test_post_wrong_with_lack_paramaters(self):
        with self.assertRaises(ValueError):
            self.response = self.w3.klay.get_header_by_hash()

