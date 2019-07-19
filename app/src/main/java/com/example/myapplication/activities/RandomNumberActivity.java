package com.example.myapplication.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.services.RandomService;

public class RandomNumberActivity extends AppCompatActivity {

    RandomService randomService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);
        Intent intent = new Intent(this, RandomService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    public void getRandomNumber(View view) {
        TextView textView = findViewById(R.id.number_textview);
        int number = randomService.getRandomNumber();
        textView.setText(Integer.toString(number));
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RandomService.LocalBinder binder = (RandomService.LocalBinder) iBinder;
            randomService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };
}
