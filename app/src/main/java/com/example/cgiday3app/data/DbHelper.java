package com.example.cgiday3app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * this class helps me create a db and create a table
 */
public class DbHelper extends SQLiteOpenHelper {

   /* private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TodoEntry.TABLE_NAME + " (" +
                    TodoEntry._ID + " INTEGER PRIMARY KEY," +
                    TodoEntry.COLUMN_NAME_TITLE + " TEXT," +
                    TodoEntry.COLUMN_NAME_SUBTITLE + " TEXT)";*/

    String SQL_CREATE_ENTRIES = "create table notes_table (_id integer primary key,title text,subtitle text)";

    /**
     * this constructor will create a db named dbname
     * @param context
     */
    public DbHelper(Context context) {
        super(context, "dbname", null, 1);
    }

    /**
     * this method will be called when we first create a db
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
