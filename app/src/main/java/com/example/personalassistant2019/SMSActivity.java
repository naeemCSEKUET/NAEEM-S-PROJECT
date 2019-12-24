package com.example.personalassistant2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {

    EditText editTextmsg,Edittext;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editTextmsg=findViewById(R.id.EdittextId1);
        Edittext=findViewById(R.id.EdittextId2);
        button=findViewById(R.id.buttonIds);




    }

    public void btn_send(View view) {

        int permissioncheck=ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS);
        if(permissioncheck== PackageManager.PERMISSION_GRANTED)
        {
            MySMS();
        }
        else
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
    }

    private void MySMS() {

        String phonenumber=editTextmsg.getText().toString().trim();
        String message=Edittext.getText().toString().trim();

        if(!editTextmsg.getText().toString().equals("")||!Edittext.getText().toString().equals("")){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phonenumber,null,message,null,null);
            Toast.makeText(this,"Message Sent",Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(this,"You must Enter text and Phone number",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==0)
        {
            if(grantResults.length>=0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                MySMS();
            }
            else
                Toast.makeText(this,"You don't have permission",Toast.LENGTH_SHORT).show();
        }


    }
}
