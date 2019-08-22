package com.example.cgiday3app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cgiday3app.data.Dao;

public class MainActivity extends AppCompatActivity {
EditText nameEt, passwordEt;
static String FILE_NAME = "mysharedprefs";
static  int MODE = Activity.MODE_PRIVATE;
static  String KEY_NAME = "name";
static  String KEY_PASS = "pass";
Dao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEt = findViewById(R.id.editTextName);
        passwordEt = findViewById(R.id.editTextPassword);
        dao = new Dao(this);
        dao.openDb();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    void saveData(){
        //get strings from edittexts
        String name = nameEt.getText().toString();
        String password = passwordEt.getText().toString();
        //create the file
        SharedPreferences preferences = getSharedPreferences(FILE_NAME,MODE);
        //write to file
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_PASS,password);
        //save file
        editor.commit();
    }
    void restoreData(){
        ////open file
        SharedPreferences preferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        //read data
        String name = preferences.getString(KEY_NAME,"");
        String password = preferences.getString(KEY_PASS,"");

        //set the data into edittexts
        nameEt.setText(name);
        passwordEt.setText(password);
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case R.id.button_save:
                String title = nameEt.getText().toString();
                String subTitle = passwordEt.getText().toString();

                dao.createRow(title,subTitle);
                break;
            case R.id.buttonget:
               String row = dao.readRow();
                TextView resTextView = findViewById(R.id.textViewRes);
                resTextView.setText(row);
                break;
        }
    }
}
