package com.ptit.hrbbci.fragchangeorientation;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SinhVienInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void dataStudent(SinhVien sv) {
        FragStudentInfo fragStudentInfo = (FragStudentInfo) getFragmentManager().findFragmentById(R.id.fragmentInfo);

        //C2
//        Configuration configuration = getResources().getConfiguration();
//        if(fragStudentInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
//            fragStudentInfo.setInfor(sv);
//        }

        if(fragStudentInfo != null && fragStudentInfo.isInLayout()){
            fragStudentInfo.setInfor(sv);
        }else{
            Intent intent = new Intent(MainActivity.this,StudentInformation.class);
            intent.putExtra("thongTinSV",sv);
            startActivity(intent);
        }
    }
}
