package com.rtlabs.srilankatoday;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.rtlabs.srilankatoday.Data.RssContract;
import com.rtlabs.srilankatoday.Data.RssDbHelper;

import java.util.ArrayList;

public class Custom extends AppCompatActivity {

    private RssDbHelper mDbHelper;
    ArrayList<CustomSource> sourcelist = new ArrayList<CustomSource>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        if (result != null){
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        }

        mDbHelper = new RssDbHelper(this);
        final CustomSourceAdapter sourceAdapter = new CustomSourceAdapter(this,sourcelist);
        ListView listView = (ListView) findViewById(R.id.cardList);
        listView.setAdapter(sourceAdapter);
        displaydbinfo();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CustomSource currentsource = sourceAdapter.getItem(position);
                Intent intent = new Intent(Custom.this,CustomNewsList.class);
                intent.putExtra("rss",currentsource.getRsslink());
                intent.putExtra("Source",currentsource.getSourceName());
                startActivity(intent);

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.customlist, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.insert) {
            Intent intent = new Intent(this,AddItem.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void displaydbinfo() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                RssContract.RssEntry.COLUMN_RSS_NAME,
                RssContract.RssEntry.COLUMN_RSS_LINK,};

        Cursor cursor = db.query(
                RssContract.RssEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);
        try{
            int RssTitleColumnIndex = cursor.getColumnIndex(RssContract.RssEntry.COLUMN_RSS_NAME);
            int RssUrlColumnIndex = cursor.getColumnIndex(RssContract.RssEntry.COLUMN_RSS_LINK);

            while (cursor.moveToNext()) {

                String currentTitle = cursor.getString(RssTitleColumnIndex);
                String currentUrl = cursor.getString(RssUrlColumnIndex);

                CustomSource source = new CustomSource(currentTitle,currentUrl);
                sourcelist.add(source);
            }
        }
        finally {

            cursor.close();
        }

    }
}
