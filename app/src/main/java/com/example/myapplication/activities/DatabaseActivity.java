package com.example.myapplication.activities;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DatabaseHelper;
import com.example.myapplication.R;

public class DatabaseActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText name, surname, mark, id;
    Button addButton, viewButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        db = new DatabaseHelper(this);
        id = findViewById(R.id.id_edittext);
        name = findViewById(R.id.name_edittext);
        surname = findViewById(R.id.surname_edittext);
        mark = findViewById(R.id.mark_edittext);
        addButton = findViewById(R.id.add_data);
        viewButton = findViewById(R.id.view_data);
        updateButton = findViewById(R.id.update_data);
        deleteButton = findViewById(R.id.delete_data);

        addData();
        viewData();
        updateData();
        deleteData();
    }

    private void deleteData() {
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows = db.deleteData(id.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(DatabaseActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();

            }
        });
    }

    public void viewData() {
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id " + res.getString(0) + "\n");
                    buffer.append("Name " + res.getString(1) + "\n");
                    buffer.append("Surname " + res.getString(2) + "\n");
                    buffer.append("Mark " + res.getInt(3) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void addData() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.insertData(name.getText().toString(),
                        surname.getText().toString(),
                        mark.getText().toString());
                if (isInserted) {
                    Toast.makeText(DatabaseActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void updateData() {
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = db.updateData(id.getText().toString(), name.getText().toString(), surname.getText().toString(), mark.getText().toString());
                if (isUpdate)
                    Toast.makeText(DatabaseActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();

            }
        });
    }
}
