package com.ptit.hrbbci.intentexplicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtResult = findViewById(R.id.txtKetQua);

        Intent intent = getIntent();

        String content = intent.getStringExtra("string");
        int content2 = intent.getIntExtra("int", 111);
        String[] arr = intent.getStringArrayExtra("array");
        Student st = (Student) intent.getSerializableExtra("Object");

        //Result from Bundle
        Bundle bundle = intent.getBundleExtra("dlBundle");
        if(bundle != null){
            String cont1 = bundle.getString("string");
            txtResult.setText(cont1);
        }


        txtResult.setText(content);
    }
}
