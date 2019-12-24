package com.example.personalassistant2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class SignUP extends AppCompatActivity {


    private EditText taxtname,username,password2,confirmpassword,textemail;
    private Button button;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Sign Up form ");
        taxtname=(EditText) findViewById(R.id.editTextname);
        username=(EditText)findViewById(R.id.editTextuser);
        password2=(EditText)findViewById(R.id.editTextpass);
        confirmpassword=(EditText)findViewById(R.id.editTextconp);
        textemail=(EditText)findViewById(R.id.editTextemail);
        button=(Button) findViewById(R.id.buttonsignupId);

        firebaseAuth=FirebaseAuth.getInstance();

        progressBar=findViewById(R.id.progressbarId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=textemail.getText().toString().trim();
                String  password=password2.getText().toString().trim();
                String confirm=confirmpassword.getText().toString().trim();
                String name=taxtname.getText().toString().trim();
                String username2=username.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(SignUP.this,"Pls Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(SignUP.this,"Pls Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confirm))
                {
                    Toast.makeText(SignUP.this,"Pls Enter confirm password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(username2))
                {
                    Toast.makeText(SignUP.this,"Pls Enter username",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(SignUP.this,"Pls Enter name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length()<6)
                {
                    Toast.makeText(SignUP.this,"password should atleast 6 char",Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                if(password.equals(confirm))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUP.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.GONE);
                                        Intent intent=new Intent(SignUP.this,LoginActivity.class);
                                        startActivity(intent);
                                        Toast.makeText(SignUP.this,"Sign up successfull",Toast.LENGTH_SHORT).show();
                                    } else {

                                        Toast.makeText(SignUP.this,"Sign up failed",Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        // ...
                                    }
                                }

                            });

                }
            }

        });
    }}