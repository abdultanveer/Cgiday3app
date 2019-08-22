package com.example.cgiday3app.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.cgiday3app.R;

public class ContentProviderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
ListView cpListView;
static int LOADER_ID = 007;
    CursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        cpListView = findViewById(R.id.cp_listview);
        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(LOADER_ID,null,this);//1
       // ContentResolver contentResolver = getContentResolver();//get the db into memory
       //Cursor dataCursor = contentResolver.query(uriSms,null,null,null,null);

         adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,  // layout for each row in the listview
                null,
                new String[]{"body","address"},
                new int[]{android.R.id.text1,android.R.id.text2});
        cpListView.setAdapter(adapter);



    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle instructions) {//2
        Uri uriSms = Uri.parse("content://sms/inbox"); //url to the inbox table in the sms db

        return new CursorLoader(this,uriSms,null,null,null,null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
