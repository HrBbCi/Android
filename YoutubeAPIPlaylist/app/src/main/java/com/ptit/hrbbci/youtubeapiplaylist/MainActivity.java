package com.ptit.hrbbci.youtubeapiplaylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String API_KEY = "AIzaSyAV8rryRwcAzbDARItWUNy-xzv0J0O7AXY";
    String ID_PLAYLIST = "PLdMqycw3-mt8Dp_2NMIyW7R5lS3wDEk69";
    String url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + ID_PLAYLIST + "&key=" + API_KEY + "&maxResults=50";

    VideoYoutubeAdapter videoYoutubeAdapter;
    ArrayList<VideoYoutube> videoYoutubeArrayList;
    ListView lvVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvVideo = findViewById(R.id.lvVideo);
        videoYoutubeArrayList = new ArrayList<>();
        videoYoutubeAdapter = new
                VideoYoutubeAdapter(this, R.layout.raw_youtube, videoYoutubeArrayList);
        lvVideo.setAdapter(videoYoutubeAdapter);
        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,PlayVideoActivity.class);
                intent.putExtra("idVideo",videoYoutubeArrayList.get(position).getId());
                startActivity(intent);
            }
        });
        getJSONYoutube(url);
    }

    private void getJSONYoutube(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast. response.toString
                        // Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonItems = response.getJSONArray("items");
                            String title = "", jsonurl = "", idVideo = "";

                            for (int i = 0; i < jsonItems.length(); i++) {
                                JSONObject jsonItem = jsonItems.getJSONObject(i);

                                JSONObject jsonSnipet = jsonItem.getJSONObject("snippet");

                                title = jsonSnipet.getString("title");

                                JSONObject jsonThumbnails = jsonSnipet.getJSONObject("thumbnails");
                                JSONObject jsonMedium = jsonThumbnails.getJSONObject("medium");

                                jsonurl = jsonMedium.getString("medium");

                                JSONObject jsonResourceId = jsonSnipet.getJSONObject("resourceId");

                                idVideo = jsonResourceId.getString("videoId");

                                videoYoutubeArrayList.add(new VideoYoutube(title,jsonurl,idVideo));
                            }
                            videoYoutubeAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
