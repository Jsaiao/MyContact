package com.aar.mycontacts.sync;

import android.accounts.AccountManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class AuthenticatorService extends Service {

    private Authenticator mAuthenticator;

    @Override
    public void onCreate() {
        Log.d("TestMe", "on create auth service");

        super.onCreate();
        mAuthenticator = new Authenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TestMe", "on bind auth service");

        if (AccountManager.ACTION_AUTHENTICATOR_INTENT.equals(intent.getAction())) {
            Log.d("TestMe", "return auth binder");

            return mAuthenticator.getIBinder();
        }
        return null;
    }
}
