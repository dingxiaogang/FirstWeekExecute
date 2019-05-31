package com.example.firstweekexercise.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VpMainAdapter extends FragmentPagerAdapter {
    private Context context;
    private ArrayList<Fragment> fragments;

    public VpMainAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
