package com.ptit.hrbbci.intentdemo;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class ImageActivity extends AppCompatActivity {

    TableLayout tblImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        tblImage = findViewById(R.id.tblImage);

        int row = 6;
        int col = 3;

        Collections.shuffle(MainActivity.arrayName);
        //Make row and col
        for (int i = 1; i <= row; i++) {
            TableRow tblRow = new TableRow(this);
            for (int j = 1; j <= col; j++) {
                ImageView imageView = new ImageView(this);

                //Covert dp to px
                Resources r = getResources();
                int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,r.getDisplayMetrics());

                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(px, px);
                imageView.setLayoutParams(layoutParams);

                final int index = row * (i - 1) + j - 1;
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(index), "drawable", getPackageName());
                imageView.setImageResource(idHinh);

                tblRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("hinhchon",MainActivity.arrayName.get(index));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            tblImage.addView(tblRow);
        }
    }
}
