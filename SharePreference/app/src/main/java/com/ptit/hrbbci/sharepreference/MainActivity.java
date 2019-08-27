package com.ptit.hrbbci.sharepreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTK;
    EditText etMK;
    Button btnDN;
    CheckBox cbNhoMK;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=  getSharedPreferences("dataLogin",MODE_PRIVATE);
        etTK.setText(sharedPreferences.getString("tk",""));
        etMK.setText(sharedPreferences.getString("mk",""));
        cbNhoMK.setChecked(sharedPreferences.getBoolean("checked",false));
        convert();

        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etTK.getText().toString().equals("a") && etMK.getText().toString().equals("a")){
                    Toast.makeText(MainActivity.this,"TC",Toast.LENGTH_SHORT).show();

                    if(cbNhoMK.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("tk",etTK.getText().toString());
                        editor.putString("mk",etMK.getText().toString());
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("tk");
                        editor.remove("mk");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void convert() {
        etTK = findViewById(R.id.etTK);
        etMK = findViewById(R.id.etMK);
        btnDN = findViewById(R.id.btnDN);
        cbNhoMK = findViewById(R.id.cbNhoMK);
    }

}
