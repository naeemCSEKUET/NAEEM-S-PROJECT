package com.example.personalassistant2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyprofileActivity extends AppCompatActivity {

    Button button;
   public static TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        button=findViewById(R.id.buttonIdp);
        tv=findViewById(R.id.textviewId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HelperParsing helperParsing=new HelperParsing();
                helperParsing.execute();

            }
        });
    }
}
