package com.example.newapp2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Time_Fragment();
            case 1: return new Range_Fragment();
            case 2: return new Height_Fragment();
            case 3: return new Velocity_Fragment(); // עכשיו כן יוצג
            default: return new Time_Fragment(); //
        }
    }

    @Override
    public int getItemCount() {
        return 4; // עכשיו 4 Fragments: 0,1,2,3
    }

    public String getTitle(int position) {
        switch (position) {
            case 0:
                return "impact time";
            case 1:
                return "impact range";
            case 2:
                return "initial height";
            case 3:
                return "velocity"; // עכשיו יש כותרת
            default:
                return "i don't know";
        }
    }
}

