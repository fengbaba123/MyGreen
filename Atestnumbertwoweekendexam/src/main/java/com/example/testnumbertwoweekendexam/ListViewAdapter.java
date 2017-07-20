package com.example.testnumbertwoweekendexam;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by admin on 2017/6/21.
 */

public class ListViewAdapter extends BaseAdapter {


    private final Context context;
    private final List<String> lists;

    public ListViewAdapter(Context context, List<String> lists) {

        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null){

            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_demo,null);

            holder.name = (TextView) convertView.findViewById(R.id.textview_adapter_name);

            convertView.setTag(holder);
        }else {

            holder = (ViewHolder) convertView.getTag();
        }


        holder.name.setText(lists.get(position));



        return convertView;
    }

    class ViewHolder{

        TextView name;

    }
}
