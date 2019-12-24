package com.example.personalassistant2019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportWeather extends AppCompatActivity {

    private TextView t1__temp, t2_city, t3_description, t4_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_weather);

        t1__temp = findViewById(R.id.t1_temp);
        t2_city = findViewById(R.id.t1_city);
        t3_description = findViewById(R.id.t1_description);
        t4_date = findViewById(R.id.t1_date);

        find_weather();

    }

    private void find_weather() {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Dhaka,BD&appID=31cb339f8869f84e13ad99e5fd723e96&units=imperial";

        JsonObjectRequest jor=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject main_object=response.getJSONObject("main");

                    JSONArray array=response.getJSONArray("weather");
                    JSONObject object=array.getJSONObject(0);
                    String temp=String.valueOf(main_object.getDouble("temp"));
                    String description=object.getString("description");
                    String city=response.getString("name");
                    //   t1__temp.setText(temp);
                    t2_city.setText(city);
                    t3_description.setText(description);
                    Calendar calendar=Calendar.getInstance();
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-YYYY");
                    String formatdate=sdf.format(calendar.getTime());
                    t4_date.setText(formatdate);
                    Double temp_int= Double.parseDouble(temp);
                    Double centi=(temp_int-32)/1.800;

                    float cen=Math.round(centi);
                    int i=(int) cen;
                    t1__temp.setText(String.valueOf(i));


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jor);



    }
}