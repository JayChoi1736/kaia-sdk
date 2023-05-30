from base.testing import KlaytnBaseTesting


class TestStartGoTrace(KlaytnBaseTesting):

    def setUp(self) -> None:
        super().setUp()
        self.file = "go.trace"

    def test_post(self):
        self.response = self.sdk.debug.start_go_trace(
            self.file
        )
        self.assertResponseSuccess()

    def test_post_wrong_with_lack_paramaters(self):
        self.response = self.sdk.debug.start_go_trace()
        self.assertErrorCodeMissingRequiredArgument()
