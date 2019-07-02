package com.stormwangxhu.androidbasic.listviewdemo.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stormwangxhu.androidbasic.R;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter {

    private List<Fruit> fruitList = new ArrayList<>();

    private Context context;

    public MyBaseAdapter(List<Fruit> fruits, Context context) {
        this.fruitList = fruits;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_fruit_item, parent, false);
            holder = new ViewHolder();
            holder.fruitImage = convertView.findViewById(R.id.fruit_image);
            holder.fruitName = convertView.findViewById(R.id.fruit_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fruitImage.setBackgroundResource(fruitList.get(position).getImageId());
        holder.fruitName.setText(fruitList.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
