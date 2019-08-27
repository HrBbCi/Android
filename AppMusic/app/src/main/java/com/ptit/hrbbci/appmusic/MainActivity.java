package com.ptit.hrbbci.appmusic;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle, txtStart, txtEnd;
    SeekBar skSong;
    ImageButton btnPrev, btnNext, btnPlay, btnStop;
    ImageView imgDisc;
    ArrayList<Song> listSong;
    int pos = 0;

    MediaPlayer mediaPlayer;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert();
        addSong();
        animation = AnimationUtils.loadAnimation(this, R.anim.disc_rotate);
        mediaPlayer();


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play);
                mediaPlayer();
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                }
                setTimeTotal();
                updateTimeSong();
                imgDisc.startAnimation(animation);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos++;
                if (pos > listSong.size() - 1) {
                    pos = 0;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                setTimeTotal();
                updateTimeSong();

            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos--;
                if (pos < 0) {
                    pos = listSong.size() - 1;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
                setTimeTotal();
                updateTimeSong();
            }
        });

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
    }

    private void updateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDang = new SimpleDateFormat("mm:ss");
                txtStart.setText(dinhDang.format(mediaPlayer.getCurrentPosition() + ""));

                skSong.setProgress(mediaPlayer.getCurrentPosition());

                //Kiem tra time bai hat end
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        pos++;
                        if (pos > listSong.size() - 1) {
                            pos = 0;
                        }
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                        }
                        mediaPlayer();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.pause);
                        setTimeTotal();
                        updateTimeSong();
                    }
                });


                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void setTimeTotal() {
        SimpleDateFormat dinhDang = new SimpleDateFormat("mm:ss");
        txtEnd.setText(dinhDang.format(mediaPlayer.getDuration() + ""));

        //gans max skSOng = media.getDuration
        skSong.setMax(mediaPlayer.getDuration());

    }

    private void mediaPlayer() {
        mediaPlayer =
                MediaPlayer.create(MainActivity.this, listSong.get(pos).getFile());
        txtTitle.setText(listSong.get(pos).getName());
    }

    private void addSong() {
        listSong = new ArrayList<>();
        listSong.add(new Song("24h", R.raw.haitugio));
        listSong.add(new Song("Nguoc loi", R.raw.ngcloi));

    }

    private void convert() {
        txtTitle = findViewById(R.id.txtTittle);
        txtStart = findViewById(R.id.txtStart);
        txtEnd = findViewById(R.id.txtEnd);
        skSong = findViewById(R.id.skSong);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        imgDisc = findViewById(R.id.imgViewDisc);

    }
}
