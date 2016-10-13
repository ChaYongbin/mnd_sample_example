package com.example.theodore.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by theodore on 2016. 10. 12..
 */

public class DAO {

    private Context context;
    private SQLiteDatabase db;

    public DAO(Context context){
        this.context = context;

        db = context.openOrCreateDatabase("LocalDATA.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String sql = "CREATE TABLE IF NOT EXISTS MH (ID integer primary key autoincrement," +
                " hsptnm text NOT NULL," +
                " zipcd text NOT NULL," +
                " hspt_addr text NOT NULL," +
                " hspt_cntadr text NOT NULL," +
                " ltd text NOT NULL," +
                " lngt text NOT NULL); " ;

        db.execSQL(sql);
    }

    public void InsertMHJsonData(JSONArray jsonArray) throws JSONException {

        String hsptnm;
        String zipcd;
        String hspt_addr;
        String hspt_cntadr;
        String ltd;
        String lngt;

        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            hsptnm = jsonObject.getString("hsptnm");
            zipcd = jsonObject.getString("zipcd");
            hspt_addr = jsonObject.getString("hspt_addr");
            hspt_cntadr = jsonObject.getString("hspt_cntadr");
            ltd = jsonObject.getString("ltd");
            lngt = jsonObject.getString("lngt");

            String sql = "INSERT INTO MH(hsptnm, zipcd, hspt_addr, hspt_cntadr, ltd, lngt) " +
                    "VALUES('" + hsptnm + "','" + zipcd + "','" + hspt_addr + "','" +
                    hspt_cntadr + "','" + ltd + "','" +  lngt + "');";

            db.execSQL(sql);

        }
    }

    public ArrayList<MHData>  getMHList() {

        ArrayList<MHData> arrayList = new ArrayList<MHData>();

        String hsptnm;
        String zipcd;
        String hspt_addr;
        String hspt_cntadr;
        String ltd;
        String lngt;

        String sql = "SELECT * FROM MH;";

        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            hsptnm = cursor.getString(1);
            zipcd = cursor.getString(2);
            hspt_addr = cursor.getString(3);
            hspt_cntadr = cursor.getString(4);
            ltd = cursor.getString(5);
            lngt = cursor.getString(6);

            arrayList.add(new MHData(hsptnm,zipcd,hspt_addr,hspt_cntadr,ltd,lngt));
        }


        return arrayList;
    }


}
