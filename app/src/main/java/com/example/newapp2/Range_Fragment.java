package com.example.newapp2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Range_Fragment extends Fragment {

    HelperDB helperDB;
    EditText etTime, etVelocity;
    TextView RangeOutput;
    double a = MainActivity1.geta();  // משתנה A שנמצא ב- MainActivity1

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // חיבור לממשק המשתמש של הפרגמנט
        View fragmentView = inflater.inflate(R.layout.range_fragment, container, false);

        // חיבור למשתנים ב-XML
        etTime = fragmentView.findViewById(R.id.etTime);
        etVelocity = fragmentView.findViewById(R.id.etVelocity);
        RangeOutput = fragmentView.findViewById(R.id.RangeOutput); // הצגת תוצאה

        // יצירת אובייקט helperDB
        helperDB = new HelperDB(getActivity());

        // חיבור לכפתור חישוב
        Button RangeClcButton = fragmentView.findViewById(R.id.RangeClcButton);
        RangeClcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // קריאת הקלטים מהמשתמש
                String time = etTime.getText().toString();
                String velocity = etVelocity.getText().toString();

                if (time.isEmpty() || velocity.isEmpty()) {
                    RangeOutput.setText("Please enter both time and velocity.");
                    return;
                }

                // הוספת הנתונים למסד הנתונים
                insertData(time, velocity);

                // חישוב הטווח והצגת התוצאה
                calculateRange(time, velocity);
            }
        });

        return fragmentView;
    }

    // פונקציה להוספת נתונים למסד הנתונים
    private void insertData(String time, String velocity) {
        SQLiteDatabase db = helperDB.getWritableDatabase();  // פתיחת מסד הנתונים לכתיבה
        ContentValues cv = new ContentValues();  // יצירת אובייקט ContentValues להוספת נתונים

        cv.put(HelperDB.COLUMN_IMPACT_TIME, time);  // הכנסת נתון זמן
        cv.put(HelperDB.COLUMN_VELOCITY, velocity);  // הכנסת נתון מהירות

        db.insert(HelperDB.DATA_TABLE, null, cv);  // הוספת הנתונים למסד
        db.close();  // סגירת מסד הנתונים
    }

    // פונקציה לחישוב הטווח
    public void calculateRange(String time, String velocity) {
        try {
            double t = Double.parseDouble(time);  // המרת זמן למספר
            double v = Double.parseDouble(velocity);  // המרת מהירות למספר

            // חישוב הטווח: Range = Velocity * Time
            double RangeResult = v * t;
            String RangeResult2 = String.format("%.2f", RangeResult); // עיגול לתוצאה

            // הצגת התוצאה ב-TextView
            RangeOutput.setText(RangeResult2 + " [m]");

        } catch (NumberFormatException nfe) {
            // טיפול בשגיאות אם המשתמש לא מזין קלט תקין
            RangeOutput.setText("Data error, please check your input.");
        }
    }
}


