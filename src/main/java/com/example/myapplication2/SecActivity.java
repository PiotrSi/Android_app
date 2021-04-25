package com.example.myapplication2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);



    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {


        super.onSaveInstanceState(outState);
    }



}
