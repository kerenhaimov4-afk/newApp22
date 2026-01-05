package com.example.newapp2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//Button ButtonC1;


public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);

        //ButtonC1=findViewById(R.id.ButtonC1);

      //  ButtonC1.setOnClickListener(new View.OnClickListener() {
          //  @Override
         //   public void onClick(View v) {
          //      Intent intent=new Intent(Fragment1.this, login.class);
       //         startActivity(intent);

      //      }
      //  });

    }



}