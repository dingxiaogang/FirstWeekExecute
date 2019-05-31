package com.example.firstweekexercise;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.firstweekexercise.adapter.VpMainAdapter;
import com.example.firstweekexercise.fragment.ParentChildFragment;
import com.example.firstweekexercise.fragment.StoryFragment;

import java.util.ArrayList;

//我是H1810B的丁晓刚 2019-5-27 19:41:25
public class MainActivity extends AppCompatActivity {

    private ViewPager mMainViewPager;
    /**
     * 故事
     */
    private RadioButton mMainRbStory;
    /**
     * 亲子
     */
    private RadioButton mMainRbParentChild;
    private RadioGroup mMainRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new StoryFragment());
        fragments.add(new ParentChildFragment());

        VpMainAdapter vpMainAdapter = new VpMainAdapter(getSupportFragmentManager(),MainActivity.this,fragments);
        mMainViewPager.setAdapter(vpMainAdapter);

        mMainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        mMainRg.check(R.id.main_rb_story);
                        break;
                    case 1:
                        mMainRg.check(R.id.main_rb_parent_child);
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
                    case R.id.main_rb_story:
                        mMainViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_rb_parent_child:
                        mMainViewPager.setCurrentItem(1);
                        break;
                }
            }
        });

    }

    private void initView() {
        mMainViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mMainRbStory = (RadioButton) findViewById(R.id.main_rb_story);
        mMainRbParentChild = (RadioButton) findViewById(R.id.main_rb_parent_child);
        mMainRg = (RadioGroup) findViewById(R.id.main_rg);
    }
}
