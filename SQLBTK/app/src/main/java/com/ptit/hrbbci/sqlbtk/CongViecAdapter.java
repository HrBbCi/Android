package com.ptit.hrbbci.sqlbtk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CongViecAdapter extends BaseAdapter {

    MainActivity context;
    int layout;
    List<CongViec> listCV;

    public CongViecAdapter(MainActivity context, int layout, List<CongViec> listCV) {
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
        TextView txtTenCV;
        ImageView imvEdit, imvDelete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder.txtTenCV = convertView.findViewById(R.id.txtTenCV);
            viewHolder.imvEdit = convertView.findViewById(R.id.imvEdit);
            viewHolder.imvDelete = convertView.findViewById(R.id.imvDelete);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final CongViec cv = listCV.get(position);
        viewHolder.txtTenCV.setText(cv.getTen());

        viewHolder.imvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialogSuaCongViec(cv);
            }
        });

        viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialogXoa(cv);
            }
        });
        return convertView;
    }
}
