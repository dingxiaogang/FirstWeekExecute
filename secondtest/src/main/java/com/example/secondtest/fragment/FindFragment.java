package com.example.secondtest.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secondtest.R;
import com.example.secondtest.adapter.VpFindAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {


    private View view;
    private ViewPager mFindViewPager;
    private TabLayout mFindTabLayout;
    private ArrayList<Integer> titles;
    private ArrayList<Fragment> fragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_find, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        titles = new ArrayList<>();
        titles.add(R.string.theme);
        titles.add(R.string.baby);

        fragments = new ArrayList<>();
        fragments.add(new ThemeFragment());
        fragments.add(new BabyFragment());

        VpFindAdapter findAdapter = new VpFindAdapter(getChildFragmentManager(),getContext(),titles,fragments);
        mFindViewPager.setAdapter(findAdapter);

        mFindTabLayout.setupWithViewPager(mFindViewPager);
    }

    private void initView(View inflate) {
        mFindViewPager = (ViewPager) inflate.findViewById(R.id.find_viewPager);
        mFindTabLayout = (TabLayout) inflate.findViewById(R.id.find_tabLayout);
    }
}
