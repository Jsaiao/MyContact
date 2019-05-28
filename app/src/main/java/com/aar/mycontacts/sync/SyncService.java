package com.aar.mycontacts.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class SyncService extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static SyncAdapter mSyncAdapter = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock){
            if(mSyncAdapter == null){
                mSyncAdapter = new SyncAdapter(getApplicationContext(),
                        true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mSyncAdapter.getSyncAdapterBinder();
    }
}