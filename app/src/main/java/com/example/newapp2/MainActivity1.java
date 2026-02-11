package com.example.newapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    private static double a = 9.8;

    public static double geta() {
        return a;
    }

    // מתודה סטטית לשינוי ערך 'a'
    public static void setA(double newa) {
        a = newa;
    }

    Button ButtonL;
    Button ButtonS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        // מציאת כפתורים
        ButtonL = findViewById(R.id.ButtonL);
        ButtonS = findViewById(R.id.ButtonS);

        // הגדרת פעולה כשנלחץ על כפתור ההתחברות
        ButtonL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, login.class);
                startActivity(intent);
            }
        });

        // הגדרת פעולה כשנלחץ על כפתור ההרשמה
        ButtonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, su.class);
                startActivity(intent);
            }
        });
    }
}
