package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

public class FornActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forn);
        getWindow().setStatusBarColor(ContextCompat.getColor(FornActivity.this, R.color.purple));
    }
}