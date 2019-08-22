package com.example.cgiday3app.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.cgiday3app.data.NoteContract.NoteEntry;

/**
 * this class helps me create a db and create a table
 */
public class DbHelper extends SQLiteOpenHelper {

   private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NoteEntry.TABLE_NAME + " (" +
                    NoteEntry._ID + " INTEGER PRIMARY KEY," +
                    NoteEntry.COLUMN_NAME_TITLE + " TEXT," +
                    NoteEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    //String SQL_CREATE_ENTRIES = "create table notes_table (_id integer primary key,title text,subtitle text)";

    /**
     * this constructor will create a db named dbname
     * @param context
     */
    public DbHelper(Context context) {
        super(context, NoteEntry.DB_NAME, null, 1);
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
