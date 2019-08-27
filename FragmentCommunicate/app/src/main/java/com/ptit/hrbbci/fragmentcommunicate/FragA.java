package com.ptit.hrbbci.fragmentcommunicate;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragA extends Fragment {

    TextView txtA;
    EditText etFragA;
    Button btnClickA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_a, container, false);
        txtA = view.findViewById(R.id.txtA);
        etFragA = view.findViewById(R.id.etFragA);

        btnClickA = view.findViewById(R.id.btnClickA);
        btnClickA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      Toast.makeText(getActivity(),"a",Toast.LENGTH_SHORT).show();
            TextView txtMain = getActivity().findViewById(R.id.txtHello);
            txtMain.setText(etFragA.getText().toString());
            }
        });
        return view;
    }

    public void ganNoiDung(String nd) {
        txtA.setText(nd);
    }
}
