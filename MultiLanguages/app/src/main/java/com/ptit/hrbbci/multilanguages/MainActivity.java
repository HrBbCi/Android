package com.ptit.hrbbci.multilanguages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvThongTin;
    Button btnXacNhan;
    EditText etTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert();
        btnXacNhan.setOnClickListener(this);
    }

    private void convert() {
        tvThongTin = findViewById(R.id.tvThongTin);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        etTen = findViewById(R.id.etTen);
    }

    @Override
    public void onClick(View v) {
        String tv_chaoban = getResources().getString(R.string.txt_chao);
        tvThongTin.setText(tv_chaoban+ ": "+etTen.getText().toString());
    }
}
