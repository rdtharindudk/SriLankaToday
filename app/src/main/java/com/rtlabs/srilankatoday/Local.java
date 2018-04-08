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
public class Local extends Fragment {

    private View view;
    public Local() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Source> sourcelist = new ArrayList<Source>();
        final SourceAdapter sourceAdapter = new SourceAdapter(getActivity(),sourcelist);

        sourcelist.add(new Source("අද දෙරණ",R.drawable.derana,"http://sinhala.adaderana.lk/rsshotnews.php"));
        sourcelist.add(new Source("හිරු නිව්ස් - සිංහල",R.drawable.hiru,"http://www.hirunews.lk/rss/sinhala.xml"));
        sourcelist.add(new Source("DailyMirror",R.drawable.dailymirror,"http://www.dailymirror.lk/RSS_Feeds/breaking-news"));
        sourcelist.add(new Source("News.lk",R.drawable.newslk,"https://www.news.lk/news?format=feed"));
        sourcelist.add(new Source("ලංකාදීප",R.drawable.lankadeepa,"http://www.lankadeepa.lk/rss/latest_news/1"));
        sourcelist.add(new Source("Ada Derana",R.drawable.derana,"http://www.adaderana.lk/rss.php"));
        sourcelist.add(new Source("BBC Sinhala",R.drawable.bbcsinhala,"http://feeds.bbc.co.uk/sinhala/index.xml"));
        sourcelist.add(new Source("OnLanka",R.drawable.onlanka,"http://feeds.feedburner.com/Onlanka"));

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
