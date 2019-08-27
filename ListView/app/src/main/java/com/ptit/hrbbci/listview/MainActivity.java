package com.ptit.hrbbci.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTraiCay;
    ArrayList<TraiCay> listTraiCay;
    TraiCayAdapter adapterTraiCay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert();

        adapterTraiCay = new TraiCayAdapter(this,R.layout.dong_trai_cay,listTraiCay);
        lvTraiCay.setAdapter(adapterTraiCay);
    }

    private void convert() {

        lvTraiCay = (ListView) findViewById(R.id.lvTC);
        listTraiCay = new ArrayList<>();
        listTraiCay.add(new TraiCay("Ảnh 1 ","b",R.drawable.a));
        listTraiCay.add(new TraiCay("Ảnh 2","b",R.drawable.b));
        listTraiCay.add(new TraiCay("Ảnh 3","b",R.drawable.c));


    }


}
