package com.sparkapps.friendzone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Syed on 2016-12-23.
 */

public class InboxFragment extends ListFragment {


    String [] mEvents = {
            "CN Tower Edgewalk",
            "10K Marathon",
            "UTSC Hackathon",
            "Cruise package to Jamaica",
            "Saturday DJ nights Ice Skating at Harborfront",
            "Camp sale at Algonquin",
            "Bungee jumping by Great Canadian Bungee",
            "Shoot your brain out at Pickering Shooting Range"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();

        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getListView().getContext(),
                android.R.layout.simple_list_item_1, mEvents);

        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getListView().getContext(), EventDetailsActivity.class);
        startActivity(intent);

    }
}