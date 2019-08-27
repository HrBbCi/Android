package com.ptit.hrbbci.fragmentcommunicate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtHello;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHello = findViewById(R.id.txtHello);
        btnChange = findViewById(R.id.btnChangeText);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragA fragA = (FragA) getFragmentManager().findFragmentById(R.id.fragmentA);
//                fragA.txtA.setText("Thay doi boi Activity");
                fragA.ganNoiDung("Changby activity");
            }
        });
    }
}
