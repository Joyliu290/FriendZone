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

public class FriendsFragment extends ListFragment {


    String [] mFriends = {
            "Ralph Emerson",
            "Albert Einstein",
            "Francis Drake",
            "Joe Donelley",
            "John Maxwell",
            "Stephen Covey",
            "Aiden James",
            "Kay Fisher",
            "Syed Rahman"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);


        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();

        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getListView().getContext(),
                android.R.layout.simple_list_item_1, mFriends);

        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getListView().getContext(), CommonListActivity.class);
        startActivity(intent);

    }
}