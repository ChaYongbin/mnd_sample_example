package com.example.theodore.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = getIntent().getExtras().getInt("postion");

        TextView textView1 = (TextView) findViewById(R.id.textView5);
        TextView textView2 = (TextView) findViewById(R.id.textView6);
        TextView textView3 = (TextView) findViewById(R.id.textView7);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        DAO dao  = new DAO(this);
        ArrayList<MHData> arrayList = dao.getMHList();

        textView1.setText(arrayList.get(position).getHsptnm());
        textView2.setText(arrayList.get(position).getHspt_addr());
        textView3.setText(arrayList.get(position).getHspt_cntadr());

        String url = "https://maps.googleapis.com/maps/api/staticmap?center="+ arrayList.get(position).getLtd() +"," + arrayList.get(position).getLngt() +"&zoom=12&size=600x400&maptype=roadmap&key=AIzaSyD92Bhijy3QI__bFdrdTbbdLXrXvsmX14Y";

        String url_2 = "https://maps.googleapis.com/maps/api/staticmap?center="+ arrayList.get(position).getLtd() +"," + arrayList.get(position).getLngt() +"&zoom=14" +
                "&size=300x200&maptype=roadmap\n" +
                "&markers=color:red%7Clabel:C%7C"+ arrayList.get(position).getLtd() +"," + arrayList.get(position).getLngt() +" " +
                "&key=AIzaSyD92Bhijy3QI__bFdrdTbbdLXrXvsmX14Y";
        Picasso.with(this).load(url_2).into(imageView);

    }
}
