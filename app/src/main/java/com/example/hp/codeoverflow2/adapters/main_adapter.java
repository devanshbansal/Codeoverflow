package com.example.hp.codeoverflow2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp.codeoverflow2.fragments.home_fragment;

public class main_adapter extends FragmentPagerAdapter {
    private static final String[] TITLES = {"SURVEY", "PROFILE", "SYNC"};

    public main_adapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

            case 1:

            case 2:

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
