package com.sparkapps.friendzone;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class EditBucketList extends AppCompatActivity {

    public final String [] mEditBLMenu = {
            "Add Items",
            "Remove Items"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bucket_list);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EditBucketList.this,
                android.R.layout.simple_list_item_1, mEditBLMenu);

        //setListAdapter(adapter);
    }
}
