package com.example.newapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button ButtonF1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ButtonF1=findViewById(R.id.ButtonF1);
        ButtonF1.setOnClickListener((v) -> {
            Intent intent = new Intent(login.this, result.class);
            super.startActivity(intent);
        });


    }
}