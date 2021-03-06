package com.example.asus.ex3.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asus.ex3.Fragment.FavoriteFragment;
import com.example.asus.ex3.Fragment.HomeFragment;
import com.example.asus.ex3.Fragment.ProfileFragment;
import com.example.asus.ex3.Fragment.SearchFragment;

/**
 * Created by Welcome on 5/21/2018.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public MainFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new SearchFragment();
        } else if (position == 2) {
            return new FavoriteFragment();
        } else {
            return new ProfileFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Search";
            case 2:
                return "Favorite Job";
            case 3:
                return "Some Criterias";
            default:
                return null;
        }
    }
}

