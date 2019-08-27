package com.ptit.hrbbci.jsonobjectlanguage;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageButton imgVN, imgEn;
    TextView txtContent;

    String noiDung="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgEn = findViewById(R.id.imgEn);
        imgVN = findViewById(R.id.imgVN);
        txtContent = findViewById(R.id.txtContent);

        new ReadJSON().execute("khoapham.vn/KhoaPhamTraining/json/tien/demo3.json");

        imgEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadLanguage("en");
            }
        });

        imgVN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadLanguage("vn");
            }
        });
    }

    private class ReadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader =
                        new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }

                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            noiDung = s;
        }
    }
    private void ReadLanguage(String language){
        try {
            JSONObject jsonObject = new JSONObject(noiDung);

            JSONObject objLanguage = jsonObject.getJSONObject("language");

            JSONObject vn = objLanguage.getJSONObject(language);

            String ten = vn.getString("name");

            txtContent.setText(ten+"\n");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
