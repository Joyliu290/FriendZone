package com.sparkapps.friendzone;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EditBucketList extends AppCompatActivity {
    SQLdatabaseActivity myDB;
    Button button_database;
    EditText enterNewBucketList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bucket_list);
    }

    public void clickMeClick (View view){
        myDB = new SQLdatabaseActivity(this);
        enterNewBucketList =(EditText) findViewById(R.id.enterNewBucketList);
        button_database = (Button) findViewById(R.id.pressMe);

        String newEntry = enterNewBucketList.getText().toString();
        if (enterNewBucketList.length() != 0) {

            Toast.makeText(EditBucketList.this, "Bucket List has been entered", Toast.LENGTH_LONG).show();
            AddData(newEntry);
            enterNewBucketList.setText("");
        } else {
            Toast.makeText(EditBucketList.this, "ERROR!", Toast.LENGTH_LONG).show();
        }
    }

    public void AddData (String newEntry) {
        boolean insertData = myDB.addData(newEntry);

        if (insertData ==true) {

            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(this, "Something went wrong",Toast.LENGTH_LONG).show();
        }

    }
}
