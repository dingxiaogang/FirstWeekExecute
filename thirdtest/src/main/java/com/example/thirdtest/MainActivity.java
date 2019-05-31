package com.example.thirdtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.thirdtest.adapter.VpMainAdapter;
import com.example.thirdtest.bean.CreationTabBean;
import com.example.thirdtest.fragment.CreationFragment;
import com.example.thirdtest.fragment.HomeFragment;
import com.example.thirdtest.fragment.MineFragment;
import com.example.thirdtest.fragment.PreferenceFragment;
import com.example.thirdtest.interfaces.ApiService;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//我是H1810B的丁晓刚 2019-5-28 16:21:49
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager mMainViewPager;
    /**
     * 首页
     */
    private RadioButton mMainHome;
    /**
     * 定制
     */
    private RadioButton mMainCreation;
    /**
     * 当地保护
     */
    private RadioButton mMainPreference;
    /**
     * 我的
     */
    private RadioButton mMainMine;
    private RadioGroup mMainRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
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
                        mMainRg.check(R.id.main_creation);
                        break;
                    case 2:
                        mMainRg.check(R.id.main_preference);
                        break;
                    case 3:
                        mMainRg.check(R.id.main_mine);
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
                    case R.id.main_creation:
                        mMainViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_preference:
                        mMainViewPager.setCurrentItem(2);
                        break;
                    case R.id.main_mine:
                        mMainViewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CreationFragment());
        fragments.add(new PreferenceFragment());
        fragments.add(new MineFragment());

        VpMainAdapter vpMainAdapter = new VpMainAdapter(getSupportFragmentManager(),fragments);
        mMainViewPager.setAdapter(vpMainAdapter);
    }

    private void initView() {
        mMainViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mMainHome = (RadioButton) findViewById(R.id.main_home);
        mMainCreation = (RadioButton) findViewById(R.id.main_creation);
        mMainPreference = (RadioButton) findViewById(R.id.main_preference);
        mMainMine = (RadioButton) findViewById(R.id.main_mine);
        mMainRg = (RadioGroup) findViewById(R.id.main_rg);
    }
}
