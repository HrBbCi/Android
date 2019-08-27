package com.ptit.hrbbci.youtubeapiplaylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoYoutubeAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<VideoYoutube> list;

    public VideoYoutubeAdapter(Context context, int layout, List<VideoYoutube> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        TextView txtTitle;
        ImageView ivIcon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(layout, null);

            holder.txtTitle = convertView.findViewById(R.id.txtTitle);
            holder.ivIcon = convertView.findViewById(R.id.ivIcon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            VideoYoutube videoYoutube = list.get(position);
        holder.txtTitle.setText(videoYoutube.getTitle());
        Picasso.get()
                .load(videoYoutube.getThumbnails())
                .into(holder.ivIcon);

        return convertView;
    }
}
