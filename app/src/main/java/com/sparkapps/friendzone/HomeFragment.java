package com.sparkapps.friendzone;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Syed on 2016-12-23.
 */

public class HomeFragment extends ListFragment {


    // myDB = new SQLdatabaseActivity(this);


    /**
     @Override
     protected void onCreate (@Nullable Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_view_list);

     ListView listview = (ListView) findViewById(R.id.listview);

     //Header for ListView
     TextView textView = new TextView(this);
     textView.setText("Entry                  Bucket Goal"); //sets the header
     listview.addHeaderView(textView); //adds the header

     //populate an ArrayList<String> from the database and then view it
     userList = new ArrayList<>();
     Cursor data = myDB.getListContents();
     int numRows = data.getCount();
     if (numRows==0) {
     Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();

     }
     else {
     int i =0;
     while (data.moveToNext()) { //returns a boolean value

     user = new User2(data.getString(0), data.getString(1));

     userList.add(i, user);

     System.out.println(data.getString(0)+ "" + data.getString(1));
     System.out.println(userList.get(i).getEntry());
     i++;

     }

     TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(this,R.layout.activity_array_list_columns,userList);
     listview.setAdapter(adapter);
     }

     } **/




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

    /** @Override
    public void onResume() {
    super.onResume();
    ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getListView().getContext(),
    android.R.layout.simple_list_item_1, mCategory);

    setListAdapter(mAdapter);
    }

    /** @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);

    Intent intent = new Intent(getListView().getContext(), PopularListActivity.class);
    startActivity(intent);

    } **/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        SQLdatabaseActivity myDB= new SQLdatabaseActivity(getActivity());

        ArrayList<User2> userList = new ArrayList<User2>();
        //String names = new String();
        User2 user;
        String newName = new String();
        Cursor data = myDB.getListContents();
        String[] names = new String [data.getCount()];

        int numRows = data.getCount();
        super.onActivityCreated(savedInstanceState);
        if (numRows == 0) {
            Toast.makeText(getActivity(), "There are no contents in this list!", Toast.LENGTH_LONG).show();

        } else {
            int i = 0;
            while (data.moveToNext()) { //returns a boolean value

                user = new User2(data.getString(0), data.getString(1));

                userList.add(i, user);

                System.out.println(data.getString(1));
                newName = data.getString(1);
                System.out.println(userList.get(i).getEntry());
                names[i] =newName.toString();

                Log.v(newName,"hi");
                i++;

            }

            //TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(getListView().getContext(),android.R.layout.s
            //
            // imple_list_item_1, userList);
            ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, names);
            setListAdapter(mAdapter);
            //setListAdapter(adapter);

        }


    }

}