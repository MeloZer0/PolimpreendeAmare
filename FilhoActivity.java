package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FilhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filho);
        getWindow().setStatusBarColor(ContextCompat.getColor(FilhoActivity.this, R.color.white));

        View vw_profile = findViewById(R.id.perfil);

        vw_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilhoActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}