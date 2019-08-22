package com.example.cgiday3app.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.cgiday3app.R;

public class ContentProviderActivity extends AppCompatActivity {
ListView cpListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        cpListView = findViewById(R.id.cp_listview);
        ContentResolver contentResolver = getContentResolver();//get the db into memory
        Uri uriSms = Uri.parse("content://sms/inbox"); //url to the inbox table in the sms db
       Cursor dataCursor = contentResolver.query(uriSms,null,null,null,null);

        CursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,  // layout for each row in the listview
                dataCursor,
                new String[]{"body","address"},
                new int[]{android.R.id.text1,android.R.id.text2});
        cpListView.setAdapter(adapter);



    }
}
