package com.ptit.hrbbci.gridviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvImage;
    List<HinhAnh> listImage;
    HinhAnhAdapter anhAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert();
        anhAdapter = new HinhAnhAdapter(this,R.layout.row_image,listImage);
        gvImage.setAdapter(anhAdapter);
        gvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Click" + listImage.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void convert() {
        gvImage = findViewById(R.id.gvImage);
        listImage = new ArrayList<>();
        listImage.add(new HinhAnh("Picture A", R.drawable.a));
        listImage.add(new HinhAnh("Picture B", R.drawable.b));
        listImage.add(new HinhAnh("Picture C", R.drawable.c));
        listImage.add(new HinhAnh("Picture A", R.drawable.a));
        listImage.add(new HinhAnh("Picture B", R.drawable.b));
        listImage.add(new HinhAnh("Picture C", R.drawable.c));
        listImage.add(new HinhAnh("Picture A", R.drawable.a));
    }



}
