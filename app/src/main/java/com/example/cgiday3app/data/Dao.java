package com.example.cgiday3app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Dao {
    DbHelper dbHelper;
    SQLiteDatabase database;

    public Dao(Context context) {
        dbHelper = new DbHelper(context);//create a db n a table
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }

    public void createRow(String mtitle, String msubTitle) {
        ContentValues values = new ContentValues();
        values.put("title",mtitle);
        values.put("subtitle",msubTitle);
        database.insert("notes_table",null,values);
    }

    public String readRow() {
       Cursor cursor = database.query("notes_table",null,null,
                null,null,null,null);
       cursor.moveToLast();
       int titleIndex = cursor.getColumnIndexOrThrow("title");
       int subTitleIndex = cursor.getColumnIndexOrThrow("subtitle");
       String title = cursor.getString(titleIndex);
       String subtitle = cursor.getString(subTitleIndex);
       return title+"\n"+subtitle;
    }
}
