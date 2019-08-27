package com.ptit.hrbbci.fragchangeorientation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragStudentInfo extends Fragment {

    TextView txtHoTen,txtNamSinh,
            txtDiaChi,txtEmail;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_student_info,container,false);

        convert();

        return  view;
    }

    public void setInfor(SinhVien sinhVien){
        txtHoTen.setText(sinhVien.getHoTen());
        txtNamSinh.setText(sinhVien.getNamSinh()+"");
        txtDiaChi.setText(sinhVien.getDiaChi());
        txtEmail.setText(sinhVien.getEmail());
    }

    private void convert(){
        txtHoTen = view.findViewById(R.id.txtHoTen);
        txtNamSinh = view.findViewById(R.id.txtNamSinh);
        txtDiaChi = view.findViewById(R.id.txtDiaChi);
        txtEmail = view.findViewById(R.id.txtEmail);
    }
}
