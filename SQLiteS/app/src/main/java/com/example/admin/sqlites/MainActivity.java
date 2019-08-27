package com.example.admin.sqlites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etTaiKhoan;
    EditText etMatKhau;
    Button btnDN,btnDK;
    UserDao ud ;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ud = new UserDao(MainActivity.this);
        convert();
        initListeners();
        initObjects();
    }

    private void initObjects() {
        user = new User();
    }

    private void convert() {
        etTaiKhoan = findViewById(R.id.txtTaiKhoan);
        etMatKhau = findViewById(R.id.txtMK);
        btnDN = findViewById(R.id.btnDangNhap);
        btnDK = findViewById(R.id.btnDangKy);
    }

    private void initListeners() {
        btnDK.setOnClickListener(this);
        btnDN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDangNhap:
                if(DN()){
                    Intent intenDN = new Intent(MainActivity.this, ListAcitivity.class);
                    startActivity(intenDN);
                }else{
                    Toast.makeText(MainActivity.this,"Dang nhap khong thanh cong",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnDangKy:
                Intent intentRegister = new Intent(MainActivity.this, DangKyActiivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private boolean DN(){
        if (ud.checkUser(new User(etTaiKhoan.getText().toString().trim(),etMatKhau.getText().toString().trim()))){
            // Snack Bar to show success message that record saved successfully
            Toast.makeText(MainActivity.this,
                    "Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
            return true;

        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(MainActivity.this,"Dang nhap khong thanh cong",Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}
