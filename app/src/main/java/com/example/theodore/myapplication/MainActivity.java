package com.example.theodore.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setSelected(true);

        LoadOpenData loadOpenData = new LoadOpenData(this);

        loadOpenData.loadData();

        Button mhListBtn = (Button) findViewById(R.id.button);
        mhListBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Intent intent = new Intent(this, MHActivity.class);
                startActivity(intent);
                break;
        }
    }
}
