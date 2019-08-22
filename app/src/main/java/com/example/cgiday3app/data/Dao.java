package com.example.cgiday3app.data;
import com.example.cgiday3app.data.NoteContract.NoteEntry;

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
        values.put(NoteEntry.COLUMN_NAME_TITLE,mtitle);
        values.put(NoteEntry.COLUMN_NAME_SUBTITLE,msubTitle);
        database.insert(NoteEntry.TABLE_NAME,null,values);
    }

    public String readRow() {
       Cursor cursor = database.query(NoteEntry.TABLE_NAME,null,null,
                null,null,null,null);
       cursor.moveToLast();
       int titleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE);
       int subTitleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_SUBTITLE);
       String title = cursor.getString(titleIndex);
       String subtitle = cursor.getString(subTitleIndex);
       return title+"\n"+subtitle;
    }
}
