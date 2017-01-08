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

public class HomeFragment extends ListFragment {



    String [] mCategory = {
            "Travel",
            "New Skill",
            "Outdoor",
            "Life Milestone",
            "DIY",
            "Nature",
            "Hiking",
            "Sports",
            "Food"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getListView().getContext(),
                android.R.layout.simple_list_item_1, mCategory);

        setListAdapter(mAdapter);
    }

      @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getListView().getContext(), PopularListActivity.class);
        startActivity(intent);

    }
}