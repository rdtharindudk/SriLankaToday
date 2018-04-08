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
public class Sports extends Fragment {


    private View view;
    public Sports() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Source> sourcelist = new ArrayList<Source>();
        final SourceAdapter sourceAdapter = new SourceAdapter(getActivity(),sourcelist);

        sourcelist.add(new Source("espncricinfo.com",R.drawable.espnci,"http://www.espncricinfo.com/rss/content/story/feeds/0.xml"));
        sourcelist.add(new Source("ESPN Soccer",R.drawable.espns,"http://www.espnfc.com/rss"));
        sourcelist.add(new Source("Fox Sports",R.drawable.foxs,"https://api.foxsports.com/v1/rss?partnerKey=zBaFxRyGKCfxBagJG9b8pqLyndmvo7UU"));
        sourcelist.add(new Source("NBA",R.drawable.nba,"http://www.nba.com/rss/nba_rss.xml"));
        sourcelist.add(new Source("UEFA Champions league",R.drawable.uefa,"https://www.uefa.com/rssfeed/uefachampionsleague/rss.xml"));

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
