package com.ptit.hrbbci.fragbundle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragA extends Fragment {

    TextView txtNoiDungA;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraga,container,false);


        txtNoiDungA = view.findViewById(R.id.txtNoiDungA);

        Bundle bundle = getArguments();
        if (bundle != null) {
            txtNoiDungA.setText(bundle.getString("hoTen"));
        }
        return view;
    }
}
