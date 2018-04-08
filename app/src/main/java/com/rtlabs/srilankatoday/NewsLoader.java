package com.rtlabs.srilankatoday;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by thari on 3/6/2018.
 */

public class NewsLoader extends AsyncTaskLoader<List<NewsItem>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<NewsItem> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<NewsItem> newsItems  = QueryUtils.fetchEarthquakeData(mUrl);
        return newsItems;
    }
}
