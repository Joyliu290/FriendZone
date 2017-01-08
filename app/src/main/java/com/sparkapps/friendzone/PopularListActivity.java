package com.sparkapps.friendzone;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PopularListActivity extends ListActivity {

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
            "Travel: Italy",
            "See the Great Barrier Reef",
            "Scuba diving",
            "Visit the Great Wall of China",
            "Travel to Australia",
            "See the Seven New Wonders of the World",
            "See New Years Eve at Times Square (New York)",
            "Travel to France",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_list);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(PopularListActivity.this,
                android.R.layout.simple_list_item_checked, mUltimateList);
        setListAdapter(mAdapter);
    }
}
