package com.example.admin.dubaothoitiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<ThoiTiet> arrayList;

    public CustomAdapter(Context context, ArrayList<ThoiTiet> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.dong_listview, null);

        ThoiTiet thoiTiet = arrayList.get(position);

        TextView txtDay = (TextView) convertView.findViewById(R.id.txngay);
        TextView txtStatus = (TextView) convertView.findViewById(R.id.txrangthai);
        TextView txtMax = (TextView) convertView.findViewById(R.id.txMax);
        TextView txtMin = (TextView) convertView.findViewById(R.id.txMin);
        ImageView imgStatus = (ImageView) convertView.findViewById(R.id.imageTrangThai);

        txtDay.setText(thoiTiet.day);
        txtStatus.setText(thoiTiet.status);
        txtMax.setText(thoiTiet.max+"°C");
        txtMin.setText(thoiTiet.min+ "°C");

        Picasso.with(context).load("http://openweathermap.org/img/w/" + thoiTiet.image+".png").into(imgStatus);

        return convertView;
    }
}
