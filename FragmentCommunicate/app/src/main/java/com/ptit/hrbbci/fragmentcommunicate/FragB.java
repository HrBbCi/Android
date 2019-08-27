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

public class FragB extends Fragment {
    TextView txtB;
    EditText etFragB;
    Button btnClickB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_b, container, false);
        txtB = view.findViewById(R.id.txtB);
        etFragB = view.findViewById(R.id.etFragB);

        btnClickB = view.findViewById(R.id.btnClickB);
        btnClickB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"a",Toast.LENGTH_SHORT).show();
                TextView txtA = getActivity().findViewById(R.id.txtA);
                txtA.setText(etFragB.getText().toString());
            }
        });
        return view;
    }
}
