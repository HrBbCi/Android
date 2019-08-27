package com.ptit.hrbbci.sqlitesaveimage;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnThem;
    public static Database database;
    ArrayList<DoVat> doVatArrayList;
    DoVatAdapter doVatAdapter;
    ListView lvDV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = findViewById(R.id.btThem);
        lvDV = findViewById(R.id.lvDoVat);
        doVatArrayList = new ArrayList<>();
        doVatAdapter = new DoVatAdapter(this,
                R.layout.dong_do_vat,doVatArrayList);
        lvDV.setAdapter(doVatAdapter);

        database= new Database(this,"qly.sqlite",null,1);
        database.queryData("CREATE TABLE IF NOT EXISTS" +
                " DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Ten VARCHAR(150)," +
                "MoTa VARCHAR(150)," +
                "HinhAnh BLOB)");

        Cursor cursor = database.getData("SELECT * FROM DoVat");
        while(cursor.moveToNext()){
            doVatArrayList.add(new DoVat(
                    cursor.getInt(cursor.getColumnIndex("Id")),
                    cursor.getString(cursor.getColumnIndex("Ten")),
                    cursor.getString(cursor.getColumnIndex("MoTa")),
                    cursor.getBlob(cursor.getColumnIndex("HinhAnh"))
            ));
        }
        doVatAdapter.notifyDataSetChanged();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ThemDoVat.class));

            }
        });
    }

}
