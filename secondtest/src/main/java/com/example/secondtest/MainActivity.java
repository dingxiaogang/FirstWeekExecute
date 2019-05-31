package com.example.secondtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.secondtest.adapter.VpMainAdapter;
import com.example.secondtest.fragment.FindFragment;
import com.example.secondtest.fragment.GrowFragment;
import com.example.secondtest.fragment.HomeFragment;
import com.example.secondtest.fragment.MeFragment;

import java.util.ArrayList;

//我是H1810B丁晓刚 2019-5-28 05:03:40
public class MainActivity extends AppCompatActivity {

    private ViewPager mMainViewPager;
    /**
     * 主页
     */
    private RadioButton mMainHome;
    /**
     * 发现
     */
    private RadioButton mMainFind;
    /**
     * 成长
     */
    private RadioButton mMainGrow;
    /**
     * 我的
     */
    private RadioButton mMainMe;
    private RadioGroup mMainRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new GrowFragment());
        fragments.add(new GrowFragment());
        fragments.add(new MeFragment());

        VpMainAdapter mainAdapter = new VpMainAdapter(getSupportFragmentManager(),fragments);
        mMainViewPager.setAdapter(mainAdapter);
    }

    private void initListener() {
        mMainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        mMainRg.check(R.id.main_home);
                        break;
                    case 1:
                        mMainRg.check(R.id.main_find);
                        break;
                    case 2:

                        break;
                    case 3:
                        mMainRg.check(R.id.main_grow);
                        break;
                    case 4:
                        mMainRg.check(R.id.main_me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mMainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_home:
                        mMainViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_find:
                        mMainViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_release:

                        break;
                    case R.id.main_grow:
                        mMainViewPager.setCurrentItem(3);
                        break;
                    case R.id.main_me:
                        mMainViewPager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    private void initView() {
        mMainViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mMainHome = (RadioButton) findViewById(R.id.main_home);
        mMainFind = (RadioButton) findViewById(R.id.main_find);
        mMainGrow = (RadioButton) findViewById(R.id.main_grow);
        mMainMe = (RadioButton) findViewById(R.id.main_me);
        mMainRg = (RadioGroup) findViewById(R.id.main_rg);
    }
}
