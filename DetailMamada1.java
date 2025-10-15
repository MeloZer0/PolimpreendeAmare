package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

public class DetailMamada1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_mamada1);
        getWindow().setStatusBarColor(ContextCompat.getColor(DetailMamada1.this, R.color.white));
    }
}