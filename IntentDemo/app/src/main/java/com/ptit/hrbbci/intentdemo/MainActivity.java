package com.ptit.hrbbci.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends Activity {

    public static ArrayList<String> arrayName;
    ImageView imgGoc, imgChon;
    int RESQUEST_CODE =123;
    String tenHinhGoc = "";
    int total = 100;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGoc = findViewById(R.id.imgGoc);
        imgChon = findViewById(R.id.imgChon);

        sharedPreferences = getSharedPreferences("luuDiem",MODE_PRIVATE);
        total = sharedPreferences.getInt("diem",100);

        String[] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));

        //Trộn mảng
        Collections.shuffle(arrayName);

        tenHinhGoc = arrayName.get(5);
        int idHinh = getResources().getIdentifier(tenHinhGoc,"drawable",getPackageName());

        imgGoc.setImageResource(idHinh);

        imgChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,
                        ImageActivity.class),RESQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == RESQUEST_CODE && resultCode == RESULT_OK && data != null){
            String tenHinhNhan = data.getStringExtra("hinhchon");
            int idHinh = getResources().getIdentifier(tenHinhNhan,"drawable",getPackageName());
            imgChon.setImageResource(idHinh);

            //Compare
            if(tenHinhGoc.equals(tenHinhNhan)){
                Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
                total += 10;
                LuuDiem();
                //Change picture
                new CountDownTimer(2000,100){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        Collections.shuffle(arrayName);

                        tenHinhGoc = arrayName.get(5);
                        int idHinh = getResources().getIdentifier(tenHinhGoc,"drawable",getPackageName());

                        imgGoc.setImageResource(idHinh);
                    }
                }.start();

            }else{
                Toast.makeText(this,"Incorrect", Toast.LENGTH_SHORT).show();
                total -= 5;
                LuuDiem();
            }
        }

        //Check cancel
        if(requestCode == RESQUEST_CODE && resultCode == RESULT_CANCELED){
            Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show();
            total -=15;
            LuuDiem();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuReload){
            Collections.shuffle(arrayName);

            tenHinhGoc = arrayName.get(5);
            int idHinh = getResources().getIdentifier(tenHinhGoc,"drawable",getPackageName());

            imgGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }

    private void LuuDiem(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("diem",total);
        editor.commit();
    }
}
