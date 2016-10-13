package com.example.theodore.myapplication;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by theodore on 2016. 10. 11..
 */

public class LoadOpenData {

    private String url_path_1 = "http://openapi.mnd.go.kr/sample/json/DS_WHLNAT_ROKAHSPT_ADDR/1/5/";

    private String url_path_2 = R.string.baseUrl + R.string.key + "/json/DS_WHLNAT_ROKAHSPT_ADDR/1/5/";

    private Context context;

    public LoadOpenData (Context context){
        this.context = context;
    }

    public void loadData(){

        ArrayList<MHData> mhDatas = new DAO(context).getMHList();

        if (mhDatas.size() > 0){
            return;
        }

        AsyncHttpClient apiClient = new AsyncHttpClient();


        apiClient.get(context, url_path_1, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String jsonData = new String(responseBody);

                Log.i("test : ", jsonData);

                try {
                    JSONObject jObj_1 = new JSONObject(jsonData);
                    JSONObject jObj_2 = new JSONObject(jObj_1.getString("DS_WHLNAT_ROKAHSPT_ADDR"));
                    JSONArray jsonArray = new JSONArray(jObj_2.getString("row"));

                    DAO dao = new DAO(context);
                    dao.InsertMHJsonData(jsonArray);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


    }

}
