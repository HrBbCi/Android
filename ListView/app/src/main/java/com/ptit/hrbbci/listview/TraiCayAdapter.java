package com.ptit.hrbbci.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    private class ViewHolder{
        TextView tvTen ;
        TextView tvMoTa ;
        ImageView imgv ;
    }
    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =  inflater.inflate(layout,null);

            holder = new ViewHolder();
            holder.tvTen = (TextView)convertView.findViewById(R.id.tvTen);
            holder.tvMoTa =(TextView) convertView.findViewById(R.id.tvMoTa);
            holder.imgv = (ImageView) convertView.findViewById(R.id.imageHinh);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        TraiCay traiCay = traiCayList.get(position);
        holder.tvTen.setText(traiCay.getTen());
        holder.tvMoTa.setText(traiCay.getMoTa());
        holder.imgv.setImageResource(traiCay.getHinh());

        //Gans animation
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list);
        convertView.startAnimation(animation);
        return convertView;


    }
}
