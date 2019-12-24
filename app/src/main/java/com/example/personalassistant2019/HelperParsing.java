package com.example.personalassistant2019;

import android.os.AsyncTask;

import org.apache.http.HttpConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HelperParsing extends AsyncTask<Void,Void,Void> {

    String data = "";

    String dataparsed="";
    String singleparsed="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/17txz4");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray array=new JSONArray(data);

            for(int i=0;i<array.length();i++)
            {
                JSONObject jo= (JSONObject) array.get(i);
                singleparsed="Name :"+jo.get("name")+"\n"+
                             "Phone :"+jo.get("Phone")+"\n"+
                             "Dept :"+jo.get("Dept")+"\n"+
                             "University :"+jo.get("University")+"\n";
                dataparsed=dataparsed+singleparsed;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MyprofileActivity.tv.setText(this.dataparsed);
    }
}
