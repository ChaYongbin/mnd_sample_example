package com.example.theodore.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MHActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh);

        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayList<MHData> mhDatas = new ArrayList<MHData>();

        mhDatas = new DAO(this).getMHList();

        MHListAdapter mhListAdapter = new MHListAdapter(this,R.layout.custom_layout, mhDatas);
        listView.setAdapter(mhListAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("position", i);
        startActivity(intent);
    }
}
