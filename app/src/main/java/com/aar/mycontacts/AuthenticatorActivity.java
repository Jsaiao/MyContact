package com.aar.mycontacts;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    private AccountManager mAccountManager;

    @Override
    protected void onCreate(Bundle icicle) {
        Log.d("TestMe", "on create authenticator activity");

        super.onCreate(icicle);
        setContentView(R.layout.activity_authenticator);

        Intent res = new Intent();
        res.putExtra(AccountManager.KEY_ACCOUNT_NAME, "mycontact_account");
        res.putExtra(AccountManager.KEY_ACCOUNT_TYPE, "com.aar.mycontacts.just_test");
        res.putExtra(AccountManager.KEY_AUTHTOKEN, "123456");
        Account account = new Account("mycontact_account", "com.aar.mycontacts.just_test");
        mAccountManager = AccountManager.get(this);
        mAccountManager.addAccountExplicitly(account, null, null);
        ContentResolver.setSyncAutomatically(account, ContactsContract.AUTHORITY, true);
        setAccountAuthenticatorResult(res.getExtras());
        setResult(RESULT_OK, res);
        finish();
    }
}
