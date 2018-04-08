package com.rtlabs.srilankatoday.Data;

import android.provider.BaseColumns;

/**
 * Created by thari on 3/12/2018.
 */

public final class RssContract {

    private RssContract(){}

    public static final class RssEntry implements BaseColumns{

        public static final String TABLE_NAME = "rsslist";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_RSS_NAME ="name";

        public final static String COLUMN_RSS_LINK ="link";

    }
}

