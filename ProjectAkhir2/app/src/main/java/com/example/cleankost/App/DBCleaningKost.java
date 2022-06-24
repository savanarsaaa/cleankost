package com.example.cleankost.App;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBCleaningKost extends SQLiteOpenHelper {


    public DBCleaningKost(@Nullable Context context) {
        super(context, "KamarMandi", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table KamarMandi (nama text, email text, alamat text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists KamarMandi");
        onCreate(db);
    }

    public void insertData(HashMap<String, String> queryValues) {
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("Nama", queryValues.get("nama"));
        nilai.put("email", queryValues.get("email"));
        nilai.put("alamat", queryValues.get("alamat"));
        basisdata.insert("kamarmandi", null, nilai);

        basisdata.close();
    }

    public ArrayList<HashMap<String, String>> getAllkamarmandi() {
        getAllkamarmandi();
        {
            ArrayList<HashMap<String, String>> daftarkamarmandi;
            daftarkamarmandi = new ArrayList<>();
            String selectQuery = "Select * from kamarmandi";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("nama", cursor.getString(0));
                    map.put("email", cursor.getString(1));
                    map.put("alamat", cursor.getString(2));
                    daftarkamarmandi.add(map);
                } while (cursor.moveToNext());
            }

            db.close();
            return daftarkamarmandi;
        }
    }
}
