package com.example.admin.sqlites;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.DB;

import java.util.ArrayList;
import java.util.List;

public class ListAcitivity extends AppCompatActivity implements View.OnClickListener {


    ListView listDS;
    ArrayList<Sach> lsSach;
    AdapterS sachAdapter;
    SachDao sachDao;
    Button btnTK;
    EditText etTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds);

        initViews();
        initListenr();
        initObjects();

        sachAdapter = new AdapterS(this, R.layout.item, lsSach);
        getDataFromSQLite();
        listDS.setAdapter(sachAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_s, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuThemS) {
            dialogThem();
        }
        return super.onOptionsItemSelected(item);
    }
    public void dialogThem() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_them);

        final EditText etTen = dialog.findViewById(R.id.etTenS);
        final EditText etLS = dialog.findViewById(R.id.etLoaiSach);
        Button btnThem = dialog.findViewById(R.id.btnThem);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenS = etTen.getText().toString();
                if (tenS == null) {
                    Toast.makeText(ListAcitivity.this, "Nhap ten", Toast.LENGTH_SHORT).show();

                } else {
                    sachDao.addSach(new Sach(0,etTen.getText().toString(),etLS.getText().toString()));
                    Toast.makeText(ListAcitivity.this, "Da them", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    getDataFromSQLite();
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
    public void dialogSuaSach(final Sach s){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua);

        final TextView txtSTT = dialog.findViewById(R.id.txtId);
        final EditText etTen = dialog.findViewById(R.id.etTenS);
        final EditText etLS = dialog.findViewById(R.id.etLoaiSach);

        Button btnSua = dialog.findViewById(R.id.btnSua);
        Button btnHuyEdit = dialog.findViewById(R.id.btnHuyEdit);

        txtSTT.setText(s.getId()+"");
        etTen.setText(s.getTen());
        etLS.setText(s.getLoai());

        btnHuyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sachDao.updateSach(new Sach(Integer.parseInt(txtSTT.getText().toString()),etTen.getText().toString(),etLS.getText().toString()));
                dialog.dismiss();
                getDataFromSQLite();
            }
        });
        dialog.show();
    }

    public void dialogXoaS(final Sach s){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Ban cos muon xoa "+s.getTen());
        dialogXoa.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sachDao.deleteSach(s);
                getDataFromSQLite();
            }
        });
        dialogXoa.setNegativeButton("khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }

    private void initViews() {
        listDS = findViewById(R.id.listDS);
        btnTK = findViewById(R.id.btnTK);
        etTK = findViewById(R.id.etTimKiem);
    }
    private void initListenr() {
        btnTK.setOnClickListener(this);

    }
    private void initObjects() {
        lsSach = new ArrayList<>();
        sachDao = new SachDao(ListAcitivity.this);
    }



    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                lsSach.clear();
                lsSach.addAll(sachDao.getAllSach());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                sachAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private void getDataFromSQLiteBYID(final String ls) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                lsSach.clear();
                lsSach.addAll(sachDao.getAllSachByLS(ls));
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                sachAdapter.notifyDataSetChanged();
            }
        }.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTK:
                String ls =etTK.getText().toString();
                getDataFromSQLiteBYID(ls);
                break;
        }
    }
}
