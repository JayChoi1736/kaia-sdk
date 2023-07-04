from base.testing import KlaytnBaseTesting


class TestDebugMemStats(KlaytnBaseTesting):

    def test_post(self):
        self.response = self.w3.debug.mem_stats()
        self.assertIsInstance(self.response["NumGC"], int)
