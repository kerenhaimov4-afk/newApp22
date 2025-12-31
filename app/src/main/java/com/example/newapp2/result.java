package com.example.newapp2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class result extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager2 viewp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        tablayout= findViewById(R.id.tablayout);
        viewp= findViewById(R.id.viewp);


        new Handler(Looper.getMainLooper()).post(() -> {
            ViewPagerAdapter a = new ViewPagerAdapter(this);
            viewp.setAdapter(a);
            viewp.setOffscreenPageLimit(1);
            new TabLayoutMediator(tablayout, viewp,
                    (t ,p) -> t.setText(a.getTitle(p))
            ).attach();
        });


    }
}