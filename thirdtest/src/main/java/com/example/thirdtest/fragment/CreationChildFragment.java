package com.example.thirdtest.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thirdtest.R;
import com.example.thirdtest.adapter.RvCreationChildAdapter;
import com.example.thirdtest.bean.CreationChildBean;
import com.example.thirdtest.model.CreationChildModelImp;
import com.example.thirdtest.presenter.CreationChildPresenterImp;
import com.example.thirdtest.view.CreationChildView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class CreationChildFragment extends Fragment implements CreationChildView {

    private static final String TAG = "CreationChildFragment";

    private View view;
    private RecyclerView mCreationChildRv;
    private int cid;

    @SuppressLint("ValidFragment")
    public CreationChildFragment(int cid) {
        this.cid = cid;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_creation_child, container, false);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser){
            initData();
        }
    }

    private void initData() {
        CreationChildPresenterImp creationChildPresenterImp = new CreationChildPresenterImp(new CreationChildModelImp(),this);
        creationChildPresenterImp.getData(cid);
    }

    private void initView(View inflate) {
        mCreationChildRv = (RecyclerView) inflate.findViewById(R.id.creation_child_rv);
    }

    @Override
    public void onSuccess(CreationChildBean data) {
        RvCreationChildAdapter creationChildAdapter = new RvCreationChildAdapter(getContext(),data.getData().getDatas());
        mCreationChildRv.setAdapter(creationChildAdapter);
        mCreationChildRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onFail(String error) {
        Log.d(TAG, "onFail: "+error);
    }
}
