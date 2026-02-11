package com.example.newapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Height_Fragment extends Fragment {

    EditText etTime;
    TextView HeightOutput;
    double a = MainActivity1.geta();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.height_fragment, container, false);

        etTime = fragmentView.findViewById(R.id.etTime);  // חיבור ל-EditText
        HeightOutput = fragmentView.findViewById(R.id.HeightOutput);  // חיבור ל-TextView

        Button HeightClcButton = fragmentView.findViewById(R.id.HeightClcButton);  // חיבור לכפתור
        HeightClcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateHeight(v);  // קריאה לפונקציה לחישוב הגובה
            }
        });

        return fragmentView;
    }

    public void calculateHeight(View view) {
        String TimeH = etTime.getText().toString();  // מקבל את הזמן שהוזן בשדה הטקסט

        if (TimeH.isEmpty()) {
            HeightOutput.setText("Please enter a time.");
            return;
        }

        try {
            double t = Double.parseDouble(TimeH);  // המרת הזמן (Time) למספר מסוג double

            double HeightResult = (a * t * t) / 2;

            // עיגול התוצאה ל-2 ספרות אחרי הנקודה
            String HeightResult2 = String.format("%.2f", HeightResult);

            // הצגת התוצאה ב-TextView
            HeightOutput.setText(HeightResult2 + " [m]");

        } catch (NumberFormatException nfe) {

            HeightOutput.setText("Data error, please check your input.");
        }
    }
}
