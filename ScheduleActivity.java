package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getWindow().setStatusBarColor(ContextCompat.getColor(ScheduleActivity.this, R.color.white));

       FloatingActionButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(ScheduleActivity.this, FornActivity.class);
            startActivity(intent);
        });

        // Encontre o ImageButton pelo seu ID
        ImageButton btn_home = findViewById(R.id.home);
        ImageButton btn_calendar = findViewById(R.id.calendar);
        ImageButton btn_info = findViewById(R.id.info);
        ImageButton btn_profile = findViewById(R.id.profile);

        // Defina um OnClickListener
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}