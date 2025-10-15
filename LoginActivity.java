package com.fausto.amare_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fausto.amare_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText editText_email, editText_password;
    Button btnLogin;
    FirebaseAuth Auth;
    ProgressBar progressBar;
    TextView tv_register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.lilac));

        setContentView(R.layout.activity_login);
        Auth = FirebaseAuth.getInstance();
        editText_email = findViewById(R.id.editTextEmail);
        editText_password = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progress_bar);
        tv_register = findViewById(R.id.create_account);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;

                email = editText_email.getText().toString();
                password = editText_password.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Enter email.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Enter password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Login Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this, "Welcome",
                                            Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = Auth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), ScheduleActivity.class);
            startActivity(intent);
            finish();
        }
    }

}