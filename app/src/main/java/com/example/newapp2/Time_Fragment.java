// Time_Fragment.java
package com.example.newapp2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class Time_Fragment extends Fragment {

    EditText etHeight;
    TextView TimeOutput;
    double a = MainActivity1.geta();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.time_fragment, container, false);

        etHeight = fragmentView.findViewById(R.id.etHeight);
        TimeOutput = fragmentView.findViewById(R.id.TimeOutput);

        Button TimeClcButton = fragmentView.findViewById(R.id.TimeClcButton);
        TimeClcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTime(v);
            }
        });

        return fragmentView;
    }

    public void calculateTime(View view) {
        String HeightT = etHeight.getText().toString();

        if (HeightT.isEmpty()) {
            TimeOutput.setText("Please enter a height.");
            return;
        }

        try {
            double h = Double.parseDouble(HeightT);
            double TimeResult = Math.sqrt(2 * h / a);
            String TimeResult2 = String.format("%.2f", TimeResult); // עיגול לתוצאה
            System.out.println(TimeResult2);
            TimeOutput.setText(TimeResult2 + " [s]");
        } catch (NumberFormatException nfe) {
            TimeOutput.setText("Data error, please check your input.");

        }
    }
}
