package com.rtlabs.srilankatoday;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rtlabs.srilankatoday.Data.RssContract;
import com.rtlabs.srilankatoday.Data.RssDbHelper;

public class AddItem extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        Button button= (Button)findViewById(R.id.btnAdd);
        final EditText nametxt = (EditText) findViewById(R.id.rsstitle);
        final EditText linktxt = (EditText) findViewById(R.id.rssurl);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String name = nametxt.getText().toString().trim();
                String url = linktxt.getText().toString().trim();
                String result = insertRssItem(name,url);
                Intent intent = new Intent(AddItem.this,Custom.class);
                intent.putExtra("result",result);
                startActivity(intent);
            }
        });


    }

    public String insertRssItem(String name, String url){

        RssDbHelper mDbHelper = new RssDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        if (!name.equals("") && !url.equals("")){
            values.put(RssContract.RssEntry.COLUMN_RSS_NAME, name);
            values.put(RssContract.RssEntry.COLUMN_RSS_LINK, url);
            long newRowId = db.insert(RssContract.RssEntry.TABLE_NAME, null, values);
            return "RSS Feed Successfully added.";
        }
        else {
            return "Error";
        }
    }


}
