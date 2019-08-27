package com.ptit.hrbbci.medialocal;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnPlayMp3;
    Button btnPlayMp4;
    VideoView vdMp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayMp3 = findViewById(R.id.btnPlayMp3);
        btnPlayMp4 = findViewById(R.id.btnPlayMp4);
        vdMp4 = findViewById(R.id.vdMp4);

        btnPlayMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer =
                        MediaPlayer.create(MainActivity.this, R.raw.promise);
                mediaPlayer.start();
            }
        });

        btnPlayMp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vdMp4.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.v));
                vdMp4.start();

                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(vdMp4);
                vdMp4.setMediaController(mediaController);
            }
        });
    }
}
