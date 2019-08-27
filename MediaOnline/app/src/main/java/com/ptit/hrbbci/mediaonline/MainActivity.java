package com.ptit.hrbbci.mediaonline;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnMp3, btnMp4;
    ProgressBar pbLoad;
    VideoView vvVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMp3 = findViewById(R.id.btnMp3);
        pbLoad = findViewById(R.id.pbLoad);
        vvVideo = findViewById(R.id.vvVideo);
        btnMp4 = findViewById(R.id.btnMp4);

        pbLoad.setVisibility(View.GONE);

        btnMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="http://khoapham.vn/download/vietnamoi.mp3";
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();

                    pbLoad.setVisibility(View.VISIBLE);

                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            pbLoad.setVisibility(View.GONE);
                            mp.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri url = Uri.parse("http://khoapham.vn/download/vuoncaovietnam.mp4");
                vvVideo.setVideoURI(url);
                vvVideo.setMediaController(new MediaController(MainActivity.this));
                vvVideo.start();
            }
        });
    }
}
