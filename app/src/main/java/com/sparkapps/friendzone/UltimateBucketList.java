package com.sparkapps.friendzone;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Syed on 2017-01-07./* public final String mUltimateBucketList = {
 "Northern Lights (Aurora Borealis)",

 };*/

public class UltimateBucketList
{
    public final ArrayList<String> mUltimateList = new ArrayList<String>();
    public String TAG = UltimateBucketList.class.getSimpleName();

    public void readFile ()
    {
        try
        {
            Scanner s = new Scanner(new File("UltimateBucketList.txt"));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.next());
            }
            s.close();
        }
        catch (Exception e)
        {
            Log.e (TAG,e.getMessage());
        }
    }
}
