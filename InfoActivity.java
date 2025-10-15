package com.fausto.amare_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getWindow().setStatusBarColor(ContextCompat.getColor(InfoActivity.this, R.color.white));

        btn1 = findViewById(R.id.button_what_is_breastfeeding);
        btn2 = findViewById(R.id.button_benefits_for_baby);
        btn3 = findViewById(R.id.button_sufficient_milk);
        btn4 = findViewById(R.id.button_positioning);
        btn5 = findViewById(R.id.button_milk_conservation);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, DetailAmamentacao1.class);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, DetailAmamentacao2.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, DetailMamada1.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, DetailMamada2.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, DetailLeiteMaterno.class);
                startActivity(intent);
            }
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
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}