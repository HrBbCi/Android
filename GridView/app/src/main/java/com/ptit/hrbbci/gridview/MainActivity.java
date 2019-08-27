package com.ptit.hrbbci.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gvTen;
    String[] arrTen ={"A","B","C","D","E","F","G","H","I","K","L","M","N","O","P","Q","R","T"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvTen  = findViewById(R.id.gvTen);
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,android.R.layout.simple_list_item_1 ,arrTen);
        gvTen.setAdapter(arrayAdapter);

    }
}
