package com.ptit.hrbbci.sqlitesaveimage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DoVatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoVat> listDV;

    public DoVatAdapter(Context context, int layout, List<DoVat> listDV) {
        this.context = context;
        this.layout = layout;
        this.listDV = listDV;
    }

    @Override
    public int getCount() {
        return listDV.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHoler{
        ImageView imgHinh;
        TextView txtMoTa, txtTen;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler holer ;
        if(convertView == null){
            holer = new ViewHoler();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holer.txtTen = convertView.findViewById(R.id.txtTenCustom);
            holer.txtMoTa = convertView.findViewById(R.id.txtMoTaCustom);
            holer.imgHinh = convertView.findViewById(R.id.imgHinhCustom);

            convertView.setTag(holer);
        }else{
             holer = (ViewHoler) convertView.getTag();
        }
        final DoVat doVat = listDV.get(position);
        holer.txtTen.setText(doVat.getTen());
        holer.txtMoTa.setText(doVat.getMota());

        //Chuyen byte ve BitMap
        byte[] hinhAnh = doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                hinhAnh,0,hinhAnh.length
        );
        holer.imgHinh.setImageBitmap(bitmap);
        holer.imgHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sua(doVat);
            }
        });
        return convertView;
    }
    public void sua(final DoVat cv){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua);


        final ImageView imgHinh =  dialog.findViewById(R.id.imgHinh);
        Button btnEdit = dialog.findViewById(R.id.btnEdit);
        Button btnHuyEdit = dialog.findViewById(R.id.btnHuyEdit);
        byte[] hinhAnh = cv.getHinh();
        final Bitmap bitmap = BitmapFactory.decodeByteArray(
                hinhAnh,0,hinhAnh.length
        );
        imgHinh.setImageBitmap(bitmap);
        btnHuyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String newTen = etTen.getText().toString();
//                database.queryData("UPDATE CongViec SET TenCV ='"+newTen+"' WHERE Id ='"+cv.getId()+"'");
//                dialog.dismiss();
//                getCV();

                Toast.makeText(v.getContext(),cv.getTen()+"",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
