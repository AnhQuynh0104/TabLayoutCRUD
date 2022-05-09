package com.example.tablayoutcrud.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.tablayoutcrud.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] imgs;

    public SpinnerAdapter(int[] imgs) {
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner, parent, false);
        ImageView imageView = v.findViewById(R.id.img);
        imageView.setImageResource(imgs[position]);
        return v;
    }
}
