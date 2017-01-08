package com.sparkapps.friendzone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CommonListActivity extends AppCompatActivity {

    protected TextView item1;
    protected TextView item2;
    protected TextView item3;
    protected TextView item4;
    protected TextView item5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_list);

        item1 = (TextView) findViewById(R.id.item1);
        item2 = (TextView) findViewById(R.id.item2);
        item3 = (TextView) findViewById(R.id.item3);
        item4 = (TextView) findViewById(R.id.item4);
        item5 = (TextView) findViewById(R.id.item5);


        item1.setText("\u2022 Ride in a hot air balloon");
        item2.setText("\u2022 Swim with the dolphins");
        item3.setText("\u2022 Go on safari");
        item4.setText("\u2022 Sleep under the stars");
        item5.setText("\u2022 Go on a road trip");


    }
}
