package com.rtlabs.srilankatoday;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Finance extends Fragment {


    private View view;
    public Finance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Source> sourcelist = new ArrayList<Source>();
        final SourceAdapter sourceAdapter = new SourceAdapter(getActivity(),sourcelist);

        sourcelist.add(new Source("Economist",R.drawable.eco,"https://www.economist.com/topics/economics/index.xml"));
        sourcelist.add(new Source("nasdaq.com",R.drawable.nasdaq,"http://articlefeeds.nasdaq.com/nasdaq/categories?category=International"));
        sourcelist.add(new Source("Business Insider",R.drawable.business,"https://www.businessinsider.in/rss_section_feeds/2147477994.cms"));

        if(view==null)
        {
            view = inflater.inflate(R.layout.fragment_breaking_news, container, false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            //parent.removeView(view);
        }

        ListView listView = (ListView) view.findViewById(R.id.cardList);
        listView.setAdapter(sourceAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Source currentsource = sourceAdapter.getItem(position);
                Intent intent = new Intent(getActivity(),NewsList.class);
                intent.putExtra("rss",currentsource.getRsslink());
                intent.putExtra("title","Sri Lanka Today - "+ currentsource.getSourceName());
                startActivity(intent);

            }
        });


        return view;
    }

}
