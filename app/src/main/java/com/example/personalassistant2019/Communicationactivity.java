package com.example.personalassistant2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class Communicationactivity extends AppCompatActivity implements View.OnClickListener {

   Button a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicationactivity);


        a=findViewById(R.id.buttonPhone);
        b=findViewById(R.id.buttonSms);
        c=findViewById(R.id.buttonYoutube);
        d=findViewById(R.id.buttonFb);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.buttonPhone)
        {
            Intent intent=new Intent(Communicationactivity.this,PhoneActivity.class);
            startActivity(intent);
            Toast.makeText(Communicationactivity.this,"Phone Activity",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonSms)
        {
            Intent intent=new Intent(Communicationactivity.this,SMSActivity.class);
            startActivity(intent);
            Toast.makeText(Communicationactivity.this,"Sms Activity",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonYoutube)
        {
            Intent intent=new Intent(Communicationactivity.this,youtbe.class);
            startActivity(intent);
            Toast.makeText(Communicationactivity.this,"youtube",Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.buttonFb)
        {
            Intent intent=new Intent(Communicationactivity.this,Fb.class);
            startActivity(intent);
            Toast.makeText(Communicationactivity.this,"Facebook",Toast.LENGTH_SHORT).show();
        }

    }
}
