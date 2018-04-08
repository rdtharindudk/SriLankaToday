package com.rtlabs.srilankatoday.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thari on 3/12/2018.
 */

public class RssDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "rsslist.db";

    private static final int DATABASE_VERSION = 1;

    public RssDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_RSSLIST_TABLE =  "CREATE TABLE " + RssContract.RssEntry.TABLE_NAME + " ("
                + RssContract.RssEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RssContract.RssEntry.COLUMN_RSS_NAME + " TEXT, "
                + RssContract.RssEntry.COLUMN_RSS_LINK + " TEXT ); ";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_RSSLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
