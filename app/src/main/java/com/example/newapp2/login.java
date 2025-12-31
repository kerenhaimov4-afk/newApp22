package com.example.newapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button ButtonF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ButtonF=findViewById(R.id.ButtonF);
        ButtonF.setOnClickListener((v) -> {
            Intent intent = new Intent(login.this, result.class);
            super.startActivity(intent);
        });


    }
}