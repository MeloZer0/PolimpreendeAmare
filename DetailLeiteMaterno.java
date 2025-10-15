package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

public class DetailLeiteMaterno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_leitematerno);
        getWindow().setStatusBarColor(ContextCompat.getColor(DetailLeiteMaterno.this, R.color.white));
    }
}