package com.example.firstmidterm;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.firstmidterm.adapter.VpShowAdapter;
import com.example.firstmidterm.fragment.AttentionFragment;
import com.example.firstmidterm.fragment.SchoolFragment;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    private TabLayout mShowTabLayout;
    private ViewPager mShowViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SchoolFragment());
        fragments.add(new AttentionFragment());

        VpShowAdapter showAdapter = new VpShowAdapter(getSupportFragmentManager(),fragments);
        mShowViewPager.setAdapter(showAdapter);

        mShowTabLayout.setupWithViewPager(mShowViewPager);
        mShowTabLayout.getTabAt(0).setText(R.string.school);
        mShowTabLayout.getTabAt(1).setText(R.string.attention);
    }

    private void initView() {
        mShowTabLayout = (TabLayout) findViewById(R.id.show_tabLayout);
        mShowViewPager = (ViewPager) findViewById(R.id.show_viewPager);
    }
}
