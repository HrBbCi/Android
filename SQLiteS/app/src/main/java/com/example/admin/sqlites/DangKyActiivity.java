package com.example.admin.sqlites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.DB;

public class DangKyActiivity extends AppCompatActivity implements View.OnClickListener {

    EditText etTaiKhoan;
    EditText etMatKhau;
    Button btnDK,btnQuayLai;
    UserDao ud ;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_dk);
        initViews();
        initListenr();
        initObjects();
    }

    private void initObjects() {
        ud = new UserDao(DangKyActiivity.this);
        user = new User();
    }

    private void initListenr() {
        btnDK.setOnClickListener(this);
        btnQuayLai.setOnClickListener(this);
    }

    private void initViews() {
        etTaiKhoan = findViewById(R.id.txtTaiKhoan);
        etMatKhau = findViewById(R.id.txtMK);
        btnDK = findViewById(R.id.btnDangKy);
        btnQuayLai = findViewById(R.id.btnQuayLai);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnQuayLai:
                Intent intent = new Intent(DangKyActiivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDangKy:
                if(DK()){
                    Intent intentTC = new Intent(DangKyActiivity.this,MainActivity.class);
                    startActivity(intentTC);
                }
        }
    }

    private boolean DK(){

        if (!ud.checkUserName(new User(etTaiKhoan.getText().toString().trim(),etMatKhau.getText().toString().trim()))){

            user.setName(etTaiKhoan.getText().toString().trim());
            user.setPassword(etMatKhau.getText().toString().trim());
            ud.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Toast.makeText(DangKyActiivity.this,
                    "Dang ky thanh cong",Toast.LENGTH_SHORT).show();
            return true;

        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(DangKyActiivity.this,"Dang ky khong thanh cong",Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
