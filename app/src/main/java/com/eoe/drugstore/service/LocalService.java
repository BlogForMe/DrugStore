package com.eoe.drugstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.ParcelUuid;

import java.util.Random;

public class LocalService extends Service {
    private final IBinder mBinder = new LocalBinder();

    private final Random mGenerator = new Random();

    public LocalService() {
    }

    public class LocalBinder extends Binder {
        public LocalService getService() {
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

}
