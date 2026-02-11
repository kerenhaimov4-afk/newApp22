package com.example.newapp2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

import java.util.ArrayList;

public class su extends AppCompatActivity {

    Button buttonF2;
    EditText etUsername, etPass, etPassC, etId;
    HelperDB helperDB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_su);


        etUsername = findViewById(R.id.etUsername);
        etPass = findViewById(R.id.etPass);
        etPassC = findViewById(R.id.etPassC);
        etId = findViewById(R.id.etId);
        buttonF2 = findViewById(R.id.ButtonF2);


        helperDB = new HelperDB(this);

        buttonF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String pass = etPass.getText().toString();
                String id = etId.getText().toString();
                insertData(username,pass,id);



                Intent intent = new Intent(su.this, result.class);
                startActivity(intent);


            }
        });
    }

    private void insertData(String username, String pass, String id) {
        SQLiteDatabase db = helperDB.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HelperDB.COLUMN_USER_NAME, username);
        cv.put(HelperDB.COLUMN_USER_PASS, pass);
        cv.put(HelperDB.COLUMN_ID, id);
        db.insert(HelperDB.USER_TABLE, null, cv);
        db.close();

    }


}



