package com.example.personalassistant2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button, loginbutton;
    private ProgressBar progressBar;
    private EditText em, pass;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Sign In form");
        button = (Button) findViewById(R.id.buttonSigninId1);
        loginbutton = (Button) findViewById(R.id.buttonloginId);
        progressBar = (ProgressBar) findViewById(R.id.progressbarId);
        em = (EditText) findViewById(R.id.edittextsigninId);
        pass = (EditText) findViewById(R.id.edittextpasssigninId);
        firebaseAuth=FirebaseAuth.getInstance();

        button.setOnClickListener(this);
        loginbutton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonloginId)
        {

            String email = em.getText().toString().trim();
            String password = pass.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(LoginActivity.this, "Pls Enter Email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(LoginActivity.this, "Pls Enter password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6) {
                Toast.makeText(LoginActivity.this, "password should atleast 6 char", Toast.LENGTH_SHORT).show();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(LoginActivity.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this,"Sign in fail",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        }
        if(v.getId()==R.id.buttonSigninId1)

        {
            Intent intent=new Intent(LoginActivity.this,SignUP.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this,"Sign Up",Toast.LENGTH_SHORT).show();

        }
    }
}


