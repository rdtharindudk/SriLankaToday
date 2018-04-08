package com.rtlabs.srilankatoday;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thari on 3/16/2018.
 */

public class CustomSourceAdapter extends ArrayAdapter<CustomSource> {

    public CustomSourceAdapter(Activity context, ArrayList<CustomSource> sources) {
        super(context, 0, sources);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.customlistitem, parent, false);
        }

        CustomSource currentSource = getItem(position);

        TextView sourcename = (TextView) listItemView.findViewById(R.id.source_name);
        sourcename.setText(currentSource.getSourceName());

        TextView sourceurl = (TextView) listItemView.findViewById(R.id.source_rss);
        sourceurl.setText(currentSource.getRsslink());

        return listItemView;
    }
}