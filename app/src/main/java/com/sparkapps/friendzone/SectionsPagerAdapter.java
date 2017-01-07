package com.sparkapps.friendzone;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Syed on 2016-12-23.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    protected Context mContext;
    public SectionsPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch (position)
        {
            case 0:
                return  new InboxFragment();
            case 1:
                return  new FriendsFragment();
        }

        return null;

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab1_title_label);
            case 1:
                return mContext.getString(R.string.tab2_title_label);
        }
        return null;
    }
}
