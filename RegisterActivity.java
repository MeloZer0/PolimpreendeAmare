package com.fausto.amare_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText editText_name, editText_email, editText_password;
    Button btnRegister;
    FirebaseAuth Auth;
    ProgressBar progressBar;
    TextView tv_LogIn;

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setStatusBarColor(ContextCompat.getColor(RegisterActivity.this, R.color.lilac));



        Auth = FirebaseAuth.getInstance();
        editText_name = findViewById(R.id.editTextName);
        editText_email = findViewById(R.id.editTextEmail);
        editText_password = findViewById(R.id.editTextPassword);
        btnRegister = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progress_barRegister);
        tv_LogIn = findViewById(R.id.loginNow);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String name, email, password;

                name = editText_name.getText().toString();
                email = editText_email.getText().toString();
                password = editText_password.getText().toString();

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(RegisterActivity.this, "Enter name.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Enter email.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Enter password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();

                                    saveData();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();


                                } else {
                                    try {
                                        throw task.getException();
                                    }catch (FirebaseAuthWeakPasswordException e) {
                                        Toast.makeText(RegisterActivity.this, "Error Password.",
                                                Toast.LENGTH_SHORT).show();
                                    }catch (FirebaseAuthUserCollisionException e){
                                        Toast.makeText(RegisterActivity.this, "User already register.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    catch (FirebaseAuthInvalidCredentialsException e){
                                        Toast.makeText(RegisterActivity.this, "Error Email.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    catch (Exception e){
                                        Toast.makeText(RegisterActivity.this, "Register Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }
                        });


            }
        });

        tv_LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void saveData(){
        String name = editText_name.getText().toString();

        FirebaseFirestore dataBase = FirebaseFirestore.getInstance();

        Map<String, Object> users = new HashMap<>();
        users.put("name", name);

        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = dataBase.collection("Users").document(userID);
        documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d("DataBase", "Successfully saved data");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("DataBaseError", "Error saved data");
                    }
                });
    }

}