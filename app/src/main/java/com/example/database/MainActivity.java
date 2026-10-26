package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAdd, btnDisplay;
    TextView t1;
    Databasehelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextText);

        btnAdd = findViewById(R.id.b1);

        btnDisplay = findViewById(R.id.b2);

        t1 = findViewById(R.id.t1);
        dbHelper = new Databasehelper(this);
    }

    public void show(View view) {
      String names = dbHelper.getAllNames();
      t1.setText(names);
    }

    public void addme(View view) {
        String name =etName.getText().toString();
        if(dbHelper.addName(name)){
            Toast.makeText(this, "Name added", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Failed to add name", Toast.LENGTH_SHORT).show();
        }
    }
}