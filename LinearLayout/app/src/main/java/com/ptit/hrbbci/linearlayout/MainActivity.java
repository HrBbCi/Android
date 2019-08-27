package com.ptit.hrbbci.linearlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnXuatThongBao , btnXinChao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnXuatThongBao =(Button) findViewById(R.id.btnXuatThongBao);
        btnXinChao =(Button) findViewById(R.id.btnXinChao);

        btnXuatThongBao.setOnClickListener(this);
        btnXinChao.setOnClickListener(this);
//        btnXuatThongBao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Xin Chào đây là btn XTB" ,Toast.LENGTH_LONG).show();
//            }
//        });
//        btnXinChao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Xin Chào đây là btn XC" ,Toast.LENGTH_LONG).show();
//            }
//        });
    }
//    public void XuatThongBao(View v){
////        String getContentView = String.valueOf(v.getId());
////        Button but = (Button) v;
////        String textBut = but.getText().toString();
////        Toast.makeText(MainActivity.this,"Xin Chào" +textBut,Toast.LENGTH_LONG).show();
//        if(String.valueOf(v.getId()).equals(R.id.btnXinChao)){
//            Toast.makeText(MainActivity.this,"Xin Chào đây là btn XIn Chào" ,Toast.LENGTH_LONG).show();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(String.valueOf(v.getId()).equals(R.id.btnXinChao)){
            Toast.makeText(MainActivity.this,"Xin Chào đây là btn XIn Chào" ,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Xin Chào đây là btn TB" ,Toast.LENGTH_LONG).show();
        }
    }
}
