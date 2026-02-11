package com.example.newapp2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Velocity_Fragment extends Fragment {

    EditText etRange, etTime;
    TextView VelocityOutput;

    HelperDB helperDB;
    double a = MainActivity1.geta();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // חיבור לממשק המשתמש של הפרגמנט
        View fragmentView = inflater.inflate(R.layout.velocity_fragment, container, false);

        etRange = fragmentView.findViewById(R.id.etRange);
        etTime = fragmentView.findViewById(R.id.etTime);
        VelocityOutput = fragmentView.findViewById(R.id.VelocityOutput); // הצגת תוצאה

        // יצירת אובייקט helperDB
        helperDB = new HelperDB(getActivity());

        Button VelocityClcButton = fragmentView.findViewById(R.id.VelocityClcButton);  // חיבור לכפתור חישוב
        VelocityClcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TimeV = etTime.getText().toString();  // קבלת הזמן שהוזן
                String RangeV = etRange.getText().toString();  // קבלת הטווח שהוזן

                if (TimeV.isEmpty() || RangeV.isEmpty()) {
                    VelocityOutput.setText("Please enter both time and range.");
                    return;
                }

                // חישוב המהירות והצגתה
                calculateVelocity(TimeV, RangeV);

                // הוספת נתונים למסד נתונים
                insertData(TimeV, RangeV);
            }
        });

        return fragmentView;
    }

    // פונקציה להוספת נתונים למסד הנתונים
    private void insertData(String time, String range) {
        SQLiteDatabase db = helperDB.getWritableDatabase();  // פותחים את מסד הנתונים
        ContentValues cv = new ContentValues();  // יצירת אובייקט ContentValues להוספת נתונים

        cv.put(HelperDB.COLUMN_IMPACT_TIME, time);
        cv.put(HelperDB.COLUMN_IMPACT_RANGE, range);

        db.insert(HelperDB.DATA_TABLE, null, cv);  // הכנסת הנתונים
        db.close();  // סגירת מסד הנתונים
    }

    // פונקציה לחישוב המהירות
    public void calculateVelocity(String TimeV, String RangeV) {
        try {
            double t = Double.parseDouble(TimeV);  // המרת זמן למספר
            double x = Double.parseDouble(RangeV);  // המרת טווח למספר

            // חישוב המהירות: Velocity = Range / Time
            double VelocityResult = x / t;
            String VelocityResult2 = String.format("%.2f", VelocityResult); // עיגול לתוצאה

            // הצגת התוצאה ב-TextView
            VelocityOutput.setText(VelocityResult2 + " [m/s]");

        } catch (NumberFormatException nfe) {
            // טיפול בשגיאות אם המשתמש לא מזין קלט תקין
            VelocityOutput.setText("Data error, please check your input.");
        }
    }
}
