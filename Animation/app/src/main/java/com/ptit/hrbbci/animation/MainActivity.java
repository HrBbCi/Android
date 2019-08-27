package com.ptit.hrbbci.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgAlpha;
    ImageView imgRotate;
    ImageView imgScale;
    ImageView imgtranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAlpha = findViewById(R.id.imgAlpha);
        imgRotate = findViewById(R.id.imgRotate);
        imgScale = findViewById(R.id.imgScale);
        imgtranslate = findViewById(R.id.imgtranslate);

        final Animation animAlpha =
                AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Animation animRotate =
                AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animScale =
                AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animTranslate =
                AnimationUtils.loadAnimation(this, R.anim.anim_translate);

        imgAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
            }
        });

        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animRotate);
            }
        });

        imgScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
            }
        });
        imgtranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTranslate);
            }
        });

    }
}
