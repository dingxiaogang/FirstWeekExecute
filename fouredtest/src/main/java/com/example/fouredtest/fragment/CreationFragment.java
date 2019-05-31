package com.example.fouredtest.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fouredtest.R;
import com.example.fouredtest.adapter.VpCreationAdapter;
import com.example.fouredtest.bean.CreationTabBean;
import com.example.fouredtest.interfaces.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreationFragment extends Fragment {

    private static final String TAG = "CreationFragment";

    private View view;
    private TabLayout mCreationTabLayout;
    private ViewPager mCreationViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_creation, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.mWanApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiService.class).getTabData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreationTabBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CreationTabBean creationTabBean) {
                        ArrayList<Fragment> fragments = new ArrayList<>();
                        ArrayList<String> titles = new ArrayList<>();
                        List<CreationTabBean.DataBean> data = creationTabBean.getData();
                        for (int i = 0; i < data.size(); i++) {
                            fragments.add(new CreationChildFragment(data.get(i).getId()));

                            titles.add(data.get(i).getName());
                        }

                        VpCreationAdapter creationAdapter = new VpCreationAdapter(getChildFragmentManager(), fragments, titles);
                        mCreationViewPager.setAdapter(creationAdapter);
                        mCreationTabLayout.setupWithViewPager(mCreationViewPager);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mCreationTabLayout = (TabLayout) inflate.findViewById(R.id.creation_tabLayout);
        mCreationViewPager = (ViewPager) inflate.findViewById(R.id.creation_viewPager);
    }
}
