package opensdk.sdk.utils;

import opensdk.sdk.models.PersonalUnlockAccountResponse;

import java.io.IOException;

public class PersonalUtils {
    public static PersonalUnlockAccountResponse unlockAccount() throws IOException {
        Integer duration = 30;
        return CommonUtils.sdk.personal.unlockAccount(CommonUtils.address, CommonUtils.passphrase, duration).send();
    }

    public static PersonalUnlockAccountResponse unlockAccountPn() throws IOException {
        Integer duration = 30;
        return CommonUtils.sdk_PN.personal.unlockAccount(
            CommonUtils.addressPN, CommonUtils.passphrasePN, duration).send();
    }
}
