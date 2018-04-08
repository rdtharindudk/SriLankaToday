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
 * Created by thari on 3/5/2018.
 */

public class SourceAdapter extends ArrayAdapter<Source> {

    public SourceAdapter(Activity context, ArrayList<Source> sources) {
        super(context, 0, sources);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_view_row, parent, false);
        }

        Source currentSource = getItem(position);

        TextView sourcename = (TextView) listItemView.findViewById(R.id.source_name);
        sourcename.setText(currentSource.getSourceName());

        ImageView sourceimage = (ImageView) listItemView.findViewById(R.id.source_icon);
        sourceimage.setImageResource(currentSource.getImageResourceId());

        return listItemView;
    }
}
