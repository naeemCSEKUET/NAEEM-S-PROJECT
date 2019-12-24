package com.example.personalassistant2019;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button_profile,button_education,button_comfort,button_goal,button_finance,button_health;
    private Button button_news,button_voice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");
        button_profile= findViewById(R.id.buttonprofileId1);
        button_education=findViewById(R.id.buttonprofileId2);
        button_comfort=findViewById(R.id.buttonprofileId3);
        button_finance=findViewById(R.id.buttonprofileId4);
        button_goal=findViewById(R.id.buttonprofileId5);
        button_voice=findViewById(R.id.buttonprofileId7);
        button_health=findViewById(R.id.buttonprofileId6);
        button_news=findViewById(R.id.buttonprofileId8);
        button_health.setOnClickListener(this);
        button_goal.setOnClickListener(this);
        button_finance.setOnClickListener(this);
        button_education.setOnClickListener(this);
        button_comfort.setOnClickListener(this);
        button_profile.setOnClickListener(this);
        button_news.setOnClickListener(this);
        button_voice.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.buttonprofileId1)
        {
          Intent intent=new Intent(MainActivity.this,MyprofileActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"Profile Activity",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonprofileId2)
        {
            Intent intent=new Intent(MainActivity.this,FireBase.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"Education Activity",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonprofileId3)
        {
            Intent intent=new Intent(MainActivity.this, controlvoice.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"Entertainment",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonprofileId4)
        {
           Intent intent=new Intent(MainActivity.this,Communicationactivity.class);
           startActivity(intent);
            Toast.makeText(MainActivity.this,"Communication",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonprofileId5)
        {
            Intent intent=new Intent(MainActivity.this, controlvoice.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"Voice Activity",Toast.LENGTH_SHORT).show();
        }
              if(v.getId()==R.id.buttonprofileId6)
        {
            //   Intent intent=new Intent(MainActivity.this, Health.class);
            //    startActivity(intent);
            Toast.makeText(MainActivity.this,"health Activity",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.buttonprofileId7)
        {
               Intent intent=new Intent(MainActivity.this, ReportWeather.class);
                startActivity(intent);
            Toast.makeText(MainActivity.this,"Report Weather",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==R.id.buttonprofileId8)
        {
            Intent intent=new Intent(MainActivity.this, News.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this,"News Activity",Toast.LENGTH_SHORT).show();
        }

    }

    @Override

    public void onBackPressed()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog= builder.create();
        alertDialog.show();


    }


}
