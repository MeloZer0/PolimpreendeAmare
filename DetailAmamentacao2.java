package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

public class DetailAmamentacao2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_amamentacao2);
        getWindow().setStatusBarColor(ContextCompat.getColor(DetailAmamentacao2.this, R.color.white));
    }
}