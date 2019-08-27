package com.ptit.hrbbci.appcaculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Float ths1, ths2;
    String toantu, xmh = "";
    EditText etGT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGT = findViewById(R.id.etGiaTri);
        int[] idButton = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5
                , R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnCham, R.id.btnChia, R.id.btnCong, R.id.btnTru, R.id.btnDel, R.id.btnNull,
                R.id.btnKetQua};

        for (int id : idButton) {
            View v = (View) findViewById(id);
            v.setOnClickListener(this);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void ToanTu() {
        ths1 = Float.parseFloat(etGT.getText().toString());
        xmh = "0";
        etGT.setText("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCong:
                toantu = "+";
                ToanTu();
                break;
            case R.id.btnTru:
                toantu = "-";
                ToanTu();
                break;
            case R.id.btnNhan:
                toantu = "*";
                ToanTu();
                break;
            case R.id.btnChia:
                toantu = "/";
                ToanTu();
                break;
            case R.id.btnKetQua:
                ths2 = Float.parseFloat(etGT.getText().toString());
                Float kq = 0f;
                if (toantu.equals("+")) {
                    kq = ths1 + ths2;
                }
                etGT.setText(kq.toString());
                ths2 = 0f;
                ths1 = 0f;
                xmh ="0";
                // Log.d("Ketqua",kq.toString());
                break;
            default:
                if (xmh.equals("0")) {
                    xmh = "";
                }
                xmh += ((Button) v).getText().toString();
                etGT.setText(xmh);

        }
    }

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
}
