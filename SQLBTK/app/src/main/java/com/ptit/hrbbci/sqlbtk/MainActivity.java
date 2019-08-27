package com.ptit.hrbbci.sqlbtk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView lvCongViec;
    ArrayList<CongViec> arrayListCongViecs;
    CongViecAdapter congViecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec = findViewById(R.id.lvCV);
        arrayListCongViecs = new ArrayList<>();
        congViecAdapter = new CongViecAdapter(this, R.layout.dong_cong_viec, arrayListCongViecs);
        //Tao db: name : ten db
        database = new Database(this, "ghichu.sqlite", null, 1);

        //Tao bang cong viec
        database.queryData(
                "CREATE TABLE IF NOT EXISTS " +
                        "CongViec(" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "TenCV VARCHAR(45))");

     //   database.queryData("INSERT INTO CongViec VALUES(null,'Lam bai tap')");
        getCV();

        lvCongViec.setAdapter(congViecAdapter);
    }

    private void getCV() {
        Cursor dataCV = database.getData("SELECT * FROM CongViec");
        CongViec congViec = null;
        arrayListCongViecs.clear();
        while (dataCV.moveToNext()) {
            //id cot 0
            int id = dataCV.getInt(0);
            String ten = dataCV.getString(1);
            Toast.makeText(MainActivity.this, ten, Toast.LENGTH_SHORT).show();
            congViec = new CongViec(id, ten);
            arrayListCongViecs.add(congViec);
        }
        congViecAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_cv, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuThem) {
            dialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    public void dialogSuaCongViec(final CongViec cv){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_suacv);

        final EditText etTen = dialog.findViewById(R.id.etSuaTenCV);
        Button btnSua = dialog.findViewById(R.id.btnSua);
        Button btnHuyEdit = dialog.findViewById(R.id.btnHuyEdit);

        etTen.setText(cv.getTen());

        btnHuyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTen = etTen.getText().toString();
                database.queryData("UPDATE CongViec SET TenCV ='"+newTen+"' WHERE Id ='"+cv.getId()+"'");
                dialog.dismiss();
                getCV();
            }
        });
        dialog.show();
    }
    public void dialogThem() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_themcv);

        final EditText etTen = dialog.findViewById(R.id.etTenCV);
        Button btnThem = dialog.findViewById(R.id.btnThem);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCV = etTen.getText().toString();
                if (tenCV == null) {
                    Toast.makeText(MainActivity.this, "Nhap ten", Toast.LENGTH_SHORT).show();

                } else {
                    database.queryData("INSERT INTO CongViec VALUES(null,'" + tenCV + "')");
                    Toast.makeText(MainActivity.this, "Da them", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getCV();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void dialogXoa(final CongViec cv){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Banj cos muon xoa "+cv.getTen());
        dialogXoa.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.queryData("DElETE FROM CongViec WHERE Id='"+cv.getId()+"'");
                getCV();
            }
        });
        dialogXoa.setNegativeButton("khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }
}
