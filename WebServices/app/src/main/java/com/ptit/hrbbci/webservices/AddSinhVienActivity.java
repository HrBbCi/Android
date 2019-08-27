package com.ptit.hrbbci.webservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddSinhVienActivity extends AppCompatActivity {

    EditText etHoTen, etDiaChi, etNamSinh;
    Button btnThem, btnHuy;
    String url = "192./insert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        convert();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themSinhVien(url);
            }
        });
    }

    private void themSinhVien(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("OK")) {
                    //Ok
                    startActivity(new Intent(
                            AddSinhVienActivity.this,MainActivity.class
                    ));
                }else{
                    //Fail Toast
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("loi",error.toString());
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("HoTen", etHoTen.getText().toString());
                params.put("NamSinh", etNamSinh.getText().toString());
                params.put("DiaChi", etDiaChi.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void convert() {
        etHoTen = findViewById(R.id.etTen);
        etDiaChi = findViewById(R.id.etDiaChi);
        etNamSinh = findViewById(R.id.etNamSinh);
        btnThem = findViewById(R.id.btnThem);
        btnHuy = findViewById(R.id.btnHuy);


    }
}
