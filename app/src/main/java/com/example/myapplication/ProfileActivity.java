package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private static ListView listView;
    private static String[] NAMES = new String[]{
            "Abraham", "Joseph", "Hussein", "Hassan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setListView();
    }

    public void onClick(View v) {
        finish();
    }

    public void setListView() {
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.name_list, NAMES);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String) listView.getItemAtPosition(position);

                        Toast.makeText(ProfileActivity.this, "Position: " + position + " Value: " + value, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
