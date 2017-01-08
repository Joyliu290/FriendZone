package com.sparkapps.friendzone;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


public class CommonListActivity extends AppCompatActivity {

    public String [] phoneNumbers = {
            "6477136386",
            "6478675431",
            "6486754321",
            "4169807654",
            "4165423789",
            "4168765490",
            "9057890765",
            "9058907652",
            "9058907654"
    };
    protected TextView item1;
    protected TextView item2;
    protected TextView item3;
    protected TextView item4;
    protected TextView item5;
    protected Button send_message;

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

        send_message = (Button) findViewById(R.id.send_message);

        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random ();
                String number = phoneNumbers[random.nextInt(phoneNumbers.length)];

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                sendIntent.putExtra("sms_body", "Hey, We have a bucket list in common, let's be bucket buddies!");
                sendIntent.putExtra("address", number);
                sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sendIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(sendIntent);

            }
        });

    }
}
