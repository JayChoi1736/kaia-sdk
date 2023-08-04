from web3py_ext import extend
import json
from unittest import TestCase
from base.constants import KLAYTN_URL, BAOBAB_URL

from web3 import Web3
from .eth import w3
class KlaytnBaseTesting(TestCase):

    def setUp(self) -> None:
        self.response = None
        self.w3 = w3

    def assertResponseSuccess(self):
        self.assertIsNotNone(self.response)
        self.assertNotIn("error", self.response)


