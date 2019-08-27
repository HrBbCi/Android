package com.ptit.hrbbci.fragchangeorientation;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragStudent extends ListFragment {

    ArrayList<SinhVien> sinhVienArrayList;
    SinhVienAdapter sinhVienAdapter;
    SinhVienInterface sinhVienInterface;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_student_list, container, false);
        sinhVienInterface = (SinhVienInterface) getActivity();
        sinhVienArrayList = new ArrayList<>();
        sinhVienAdapter = new SinhVienAdapter(getActivity(), R.layout.raw_student, sinhVienArrayList);
        AddArraySV();
        setListAdapter(sinhVienAdapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        sinhVienInterface.dataStudent(sinhVienArrayList.get(position));
    }

    private void AddArraySV() {
        sinhVienArrayList.add(new SinhVien("A", ",", ",", 1997));
        sinhVienArrayList.add(new SinhVien("B", ",", ",", 1997));
        sinhVienArrayList.add(new SinhVien("C", ",", ",", 1997));
    }
}
