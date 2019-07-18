package com.example.myapplication.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.fragments.FirstFragment;
import com.example.myapplication.R;
import com.example.myapplication.fragments.SecondFragment;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void changeFragment(View view) {
        Fragment fragment;

        if (view == findViewById(R.id.fragmentOne)) {
            fragment = new FirstFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
        }

        if (view == findViewById(R.id.fragmentTwo)) {
            fragment = new SecondFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();

        }
    }
}
