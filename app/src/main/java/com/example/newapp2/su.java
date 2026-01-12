package com.example.newapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class su extends AppCompatActivity {
    Button ButtonF2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_su);
        ButtonF2=findViewById(R.id.ButtonF2);
        ButtonF2.setOnClickListener((v) -> {
            Intent intent = new Intent(su.this, result.class);
            super.startActivity(intent);
        });


    }
    }
