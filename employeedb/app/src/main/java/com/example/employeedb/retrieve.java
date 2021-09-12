package com.example.employeedb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import androidx.appcompat.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class retrieve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        final EditText eCode = findViewById(R.id.eCodeRetrieve);
        final EditText eDept = findViewById(R.id.eDeptRetrieve);
        final Button retrieve = findViewById(R.id.retrieve);
        final Button retrieveDept = findViewById(R.id.retrieveDept);
        final DBHelper DB = new DBHelper(this);
        retrieve.setOnClickListener(view -> {
            String code = eCode.getText().toString();
            Cursor res = DB.retrieveEmployee(code);
            if(res.getCount() == 0)
                Toast.makeText(retrieve.this, "No Records Found", Toast.LENGTH_SHORT).show();
            else {
                StringBuilder buffer = new StringBuilder();
                while(res.moveToNext()) {
                    buffer.append("Employee Code : ").append(res.getString(0)).append("\n");
                    buffer.append("Employee Name : ").append(res.getString(1)).append("\n");
                    buffer.append("Employee Sex : ").append(res.getString(2)).append("\n");
                    buffer.append("Employee Dept : ").append(res.getString(3)).append("\n");
                    buffer.append("Employee Pay : ").append(res.getString(4)).append("\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(retrieve.this);
                builder.setCancelable(true);
                builder.setTitle("Employee Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        retrieveDept.setOnClickListener(view -> {
            String dept = eDept.getText().toString();
            Cursor res = DB.retrieveDepartment(dept);
            if(res.getCount() == 0)
                Toast.makeText(retrieve.this, "No Records Found", Toast.LENGTH_SHORT).show();
            else {
                StringBuilder buffer = new StringBuilder();
                while(res.moveToNext()) {
                    buffer.append("Employee Code : ").append(res.getString(0)).append("\n");
                    buffer.append("Employee Name : ").append(res.getString(1)).append("\n");
                    buffer.append("Employee Sex : ").append(res.getString(2)).append("\n");
                    buffer.append("Employee Dept : ").append(res.getString(3)).append("\n");
                    buffer.append("Employee Pay : ").append(res.getString(4)).append("\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(retrieve.this);
                builder.setCancelable(true);
                builder.setTitle("Employee Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}