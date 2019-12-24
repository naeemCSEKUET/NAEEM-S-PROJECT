package com.example.personalassistant2019;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.net.URI;

public class DatabaseActivity extends AppCompatActivity {

    Button button1,button2;
    TextView textView;
    URI pdfuri;
   FirebaseStorage storage;
   FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

        button1=findViewById(R.id.dbuttonid1);
        button2=findViewById(R.id.dbuttonId3);
        textView=findViewById(R.id.dtextviewId);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(DatabaseActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                {
                    selectpdf();
                }
                else
                    ActivityCompat.requestPermissions(DatabaseActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
            }

            
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==9&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectpdf();
        }
        else
            Toast.makeText(DatabaseActivity.this,"please provide permission",Toast.LENGTH_SHORT).show();
    }

    private void selectpdf() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);

    }


}
