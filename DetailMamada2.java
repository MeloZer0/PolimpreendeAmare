package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

public class DetailMamada2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_mamada2);
        getWindow().setStatusBarColor(ContextCompat.getColor(DetailMamada2.this, R.color.white));
    }
}