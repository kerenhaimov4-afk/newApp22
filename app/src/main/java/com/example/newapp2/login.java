package com.example.newapp2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button ButtonF1;
    EditText editTextUsername, editTextPassword;
    HelperDB hlpdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        hlpdb = new HelperDB(this);
        ButtonF1 = findViewById(R.id.ButtonF1);

        ButtonF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String pass = editTextPassword.getText().toString();

                SQLiteDatabase db = hlpdb.getReadableDatabase();

                Cursor cursor = db.query(
                        hlpdb.USER_TABLE,
                        null,
                        hlpdb.COLUMN_USER_NAME + "=? AND " + hlpdb.COLUMN_USER_PASS + "=?",
                        new String[]{username, pass},
                        null,
                        null,
                        null);

                if (cursor != null && cursor.moveToFirst()) {
                    Intent intent = new Intent(login.this, result.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(login.this, "שם משתמש או סיסמה לא נכונים", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                if (cursor != null) cursor.close();
                db.close();
            }
        });
    }
}
