package com.example.secondtest.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VpFindAdapter extends FragmentPagerAdapter {
    private Context context;
    private ArrayList<Integer> titles;
    private ArrayList<Fragment> fragments;

    public VpFindAdapter(FragmentManager fm, Context context, ArrayList<Integer> titles, ArrayList<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.titles = titles;
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(titles.get(position));
    }
}
