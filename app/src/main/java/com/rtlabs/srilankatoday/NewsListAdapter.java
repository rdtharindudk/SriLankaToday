package com.rtlabs.srilankatoday;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thari on 3/6/2018.
 */

public class NewsListAdapter extends ArrayAdapter<NewsItem>{

    public NewsListAdapter(Activity context, ArrayList<NewsItem> newsItems) {

        super(context, 0, newsItems);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        NewsItem currentnewsitem = getItem(position);

        TextView headline = (TextView) listItemView.findViewById(R.id.headline);
        headline.setText(currentnewsitem.getHeadline());

        TextView description = (TextView) listItemView.findViewById(R.id.description);
        description.setText(currentnewsitem.getDescription());

        TextView pubdate = (TextView) listItemView.findViewById(R.id.pubDate);
        if (currentnewsitem.getPubDate().equals("null")) {
            pubdate.setText(null);
        }else {
            pubdate.setText("Published on " + currentnewsitem.getPubDate());
        }
        return listItemView;
    }
}
