package com.example.employeedb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button create_button = findViewById(R.id.create);
        Button insert_button = findViewById(R.id.insert);
        Button update_button = findViewById(R.id.update);
        Button delete_button = findViewById(R.id.delete);
        Button retrieve_button = findViewById(R.id.retrieve);
        create_button.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "Database Created", Toast.LENGTH_SHORT).show());
        insert_button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),insert.class)));
        update_button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), update.class)));
        delete_button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), delete.class)));
        retrieve_button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), retrieve.class)));

    }
}