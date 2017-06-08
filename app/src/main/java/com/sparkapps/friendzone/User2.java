package com.sparkapps.friendzone;

/**
 * Created by Joyli on 2017-06-08.
 */

public class User2 {

    private String ID;
    private String bucketList2;

    public User2 (String Entry, String bucketList){

        ID = Entry;
        bucketList2 = bucketList;

    }

    public String getEntry(){
        return ID;

    }

    public void setEntry (String Entry2){
        ID = Entry2;
    }

    public String getBucketList2() {
        return bucketList2;
    }

    public void setBucketList2 (String bucketList3 ){

        bucketList2 = bucketList3;
    }
}

