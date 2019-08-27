package com.ptit.hrbbci.webservices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTen, txtNamSinh, txtDiaChi;
        ImageView ivEdit, ivDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTen = convertView.findViewById(R.id.txtTenSV);
            holder.txtNamSinh = convertView.findViewById(R.id.txtNamSinh);
            holder.txtDiaChi = convertView.findViewById(R.id.txtDiaChi);
            holder.ivEdit = convertView.findViewById(R.id.ivEdit);
            holder.ivDelete = convertView.findViewById(R.id.ivDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SinhVien sv = sinhVienList.get(position);
        holder.txtTen.setText(sv.getHoTen());
        holder.txtNamSinh.setText(sv.getNamSinh() + "");
        holder.txtDiaChi.setText(sv.getDiaChi());
        return convertView;
    }
}
