package com.sparkapps.friendzone;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EditBucketList extends ListActivity {

    public UltimateBucketList ultimateBucketList = new UltimateBucketList();
    private FirebaseAuth mFireBaseAuth;
    protected DatabaseReference mDatabase;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> mUserBucket = new ArrayList<String>() ;
    public String [] mUltimateList = {
            "See Northern Lights (Aurora Borealis)",
            "Ride in a hot air balloon",
            "See Grand Canyon, Arizonasee and Grand Canyon, Arizona",
            "Swim with the dolphins",
            "Go on safari",
            "Sleep under the stars",
            "Ride in a helicopter",
            "Go on a road trip",
            "Travel: to the seven continents",
            "Make a difference in someone's life",
            "Travel: Italy",
            "See the Great Barrier Reef",
            "Scuba diving",
            "Shower in a waterfall",
            "Sky diving",
            "Visit the Great Wall of China",
            "Travel to Australia",
            "Ride an elephant",
            "Learn French",
            "Go whale-watching",
            "See the Seven New Wonders of the World",
            "See New Years Eve at Times Square (New York)",
            "Travel to France",
    };

    ArrayList <String> bucketList = new ArrayList<String> (Arrays.asList(mUltimateList));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bucket_list);
        //ultimateBucketList.readFile();
        mFireBaseAuth = FirebaseAuth.getInstance();
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(EditBucketList.this,
                android.R.layout.simple_list_item_checked, mUltimateList);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (getListView().isItemChecked(position)) {
            String item =  mUltimateList[position];
            mDatabase = FirebaseDatabase.getInstance().getReference();
            String userId = mFireBaseAuth.getCurrentUser().getUid();
            HashMap<String, String> names = new HashMap<String, String>();
            names.put("Item", item);
            mDatabase.child("users").child(userId).child("bucketlist").setValue(names);
        }
    }
}


