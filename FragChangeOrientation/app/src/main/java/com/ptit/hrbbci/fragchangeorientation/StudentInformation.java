package com.ptit.hrbbci.fragchangeorientation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);

        Intent intent = getIntent();
        SinhVien sv = (SinhVien) intent.getSerializableExtra("thongTinSV");

        FragStudentInfo studentInfo = (FragStudentInfo) getFragmentManager().findFragmentById(R.id.fragmentChiTiet);
        studentInfo.setInfor(sv);


    }
}
