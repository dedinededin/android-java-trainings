package com.example.myapplication.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class RandomService extends Service {
    private final IBinder iBinder = new LocalBinder();
    private final Random random = new Random();


    public class LocalBinder extends Binder {
        public RandomService getService() {
            return RandomService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public int getRandomNumber(){
        return random.nextInt(100);
    }
}
