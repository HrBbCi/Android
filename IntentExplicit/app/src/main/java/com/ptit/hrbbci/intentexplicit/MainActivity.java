package com.ptit.hrbbci.intentexplicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr = {"A","B","C"};
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("string", "Nội dung chuỗi");
                intent.putExtra("int",200);
                intent.putExtra("array",arr);

                Student st = new Student("A", 1997);
                intent.putExtra("Object", st);

                //Bundle
                Bundle bundle = new Bundle();
                bundle.putString("string","Hello");
                bundle.putInt("int",125);
                bundle.putStringArray("arr",arr);
                bundle.putSerializable("Object",st);
                intent.putExtra("dlBundle",bundle);

                startActivity(intent);
            }
        });
    }
}
