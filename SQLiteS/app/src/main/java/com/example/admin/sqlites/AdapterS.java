package com.example.admin.sqlites;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.sqlites.MainActivity;
import com.example.admin.sqlites.R;
import com.example.admin.sqlites.Sach;

import java.util.ArrayList;
import java.util.List;

public class AdapterS extends BaseAdapter {

    ListAcitivity context;
    int layout;
    List<Sach> listCV;

    public AdapterS(ListAcitivity context, int layout, List<Sach> listCV) {
        this.context = context;
        this.layout = layout;
        this.listCV = listCV;
    }

    @Override
    public int getCount() {
        return listCV.size();
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
        TextView tvSTT;
        TextView tvTen;
        TextView tvLoai;
        ImageView imvEdit, imvDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder.tvSTT = convertView.findViewById(R.id.tvSTT);
            viewHolder.tvTen = convertView.findViewById(R.id.tvTen);
            viewHolder.tvLoai = convertView.findViewById(R.id.tvLoai);
            viewHolder.imvEdit = convertView.findViewById(R.id.imvEdit);
            viewHolder.imvDelete = convertView.findViewById(R.id.imvDelete);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Sach cv = listCV.get(position);
        viewHolder.tvSTT.setText(cv.getId()+"");
        viewHolder.tvTen.setText(cv.getTen());
        viewHolder.tvLoai.setText(cv.getLoai());
        viewHolder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialogSuaSach(cv);
            }
        });

        viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialogXoaS(cv);
            }
        });
        return convertView;
    }
}
