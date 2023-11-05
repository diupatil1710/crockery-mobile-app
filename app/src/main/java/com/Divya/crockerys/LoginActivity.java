package com.Divya.crockerys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    private FirebaseAuth auth;

//    @Override
//    public void onStart()
//    {
//        super.onStart();
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if(currentUser !=null){
//            startActivity(new Intent(LoginActivity.this,MainActivity.class));
//            finish();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();

        email=findViewById(R.id.Email);
        password=findViewById(R.id.Passward);
    }

    public void signin(View view) {

        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (TextUtils.isEmpty(userEmail)){
            Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPassword.length() < 6){
            Toast.makeText(this,"Password too short,enter minimum  6 character",Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(userEmail,userPassword)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


    }

    public void signup(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
}