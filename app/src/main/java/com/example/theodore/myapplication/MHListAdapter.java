package com.example.theodore.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.theodore.myapplication.R.id.textView;

/**
 * Created by theodore on 2016. 10. 12..
 */

public class MHListAdapter extends ArrayAdapter<MHData> {

    private Context context;
    private int resource;
    private LayoutInflater mInflater;
    private ArrayList<MHData> mhDatas;

    public MHListAdapter(Context context, int resource, ArrayList<MHData> mhDatas) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.mhDatas = mhDatas;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mhDatas.size();
    }


    @Override
    public MHData getItem(int position) {
        return mhDatas.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView1;
        TextView textView2;


        if(convertView == null){
            convertView = mInflater.inflate(R.layout.custom_layout, null);
            textView1 = (TextView)convertView.findViewById(R.id.textView3);
            textView2 = (TextView)convertView.findViewById(R.id.textView4);
            convertView.setTag(textView1);
            convertView.setTag(textView2);
        } else {
            textView1 = (TextView) convertView.getTag();
            textView2 = (TextView) convertView.getTag();

        }

        textView1.setText(mhDatas.get(position).getHsptnm().toString());
        textView2.setText(mhDatas.get(position).getHspt_addr().toString());

        return convertView;
    }
}
