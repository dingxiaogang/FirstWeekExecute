package com.example.secondmidterm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.secondmidterm.R;
import com.example.secondmidterm.bean.MainBean;

import java.util.ArrayList;

public class RvMainAdapter extends RecyclerView.Adapter {
    public ArrayList<MainBean.DataBean.DatasBean> mainData;
    private onClickListener clickListener;

    public RvMainAdapter(ArrayList<MainBean.DataBean.DatasBean> mainData) {
        this.mainData = mainData;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 4){
            return 0;
        }else if (position % 2 == 0){
            return 1;
        }else if (position % 2 == 1){
            return 2;
        }else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_list_one, viewGroup, false);
            return new MainViewHolderOne(inflate);
        }else if (i == 1){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_list_two, viewGroup, false);
            return new MainViewHolderTwo(inflate);
        }else if (i == 2){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_list_three, viewGroup, false);
            return new MainViewHolderThree(inflate);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        MainBean.DataBean.DatasBean datasBean = mainData.get(i);
        if (itemViewType == 0){
            MainViewHolderOne mainViewHolderOne = (MainViewHolderOne) viewHolder;
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(viewHolder.itemView.getContext()).load(datasBean.getEnvelopePic()).apply(options).into(mainViewHolderOne.imageView);
            mainViewHolderOne.title.setText(datasBean.getTitle());
            mainViewHolderOne.desc.setText(datasBean.getNiceDate());
        }else if (itemViewType == 1){
            MainViewHolderTwo mainViewHolderTwo = (MainViewHolderTwo) viewHolder;
            Glide.with(viewHolder.itemView.getContext()).load(datasBean.getEnvelopePic()).into(mainViewHolderTwo.imageView2);
            mainViewHolderTwo.title2.setText(datasBean.getTitle());
        }else if (itemViewType == 2){
            MainViewHolderThree mainViewHolderThree = (MainViewHolderThree) viewHolder;
            Glide.with(viewHolder.itemView.getContext()).load(datasBean.getEnvelopePic()).into(mainViewHolderThree.imageView3_1);
            mainViewHolderThree.title3_1.setText(datasBean.getTitle());
            Glide.with(viewHolder.itemView.getContext()).load(datasBean.getEnvelopePic()).into(mainViewHolderThree.imageView3_2);
            mainViewHolderThree.title3_2.setText(datasBean.getTitle());
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.onClick(v,i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainData.size();
    }

    class MainViewHolderOne extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView desc;

        public MainViewHolderOne(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ma_image);
            title = itemView.findViewById(R.id.ma_title);
            desc = itemView.findViewById(R.id.ma_desc);
        }
    }

    class MainViewHolderTwo extends RecyclerView.ViewHolder {
        private ImageView imageView2;
        private TextView title2;

        public MainViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.ma_image2);
            title2 = itemView.findViewById(R.id.ma_title2);
        }
    }

    class MainViewHolderThree extends RecyclerView.ViewHolder {
        private ImageView imageView3_1;
        private TextView title3_1;
        private ImageView imageView3_2;
        private TextView title3_2;

        public MainViewHolderThree(@NonNull View itemView) {
            super(itemView);
            imageView3_1 = itemView.findViewById(R.id.ma_image3_1);
            title3_1 = itemView.findViewById(R.id.ma_title3_1);
            imageView3_2 = itemView.findViewById(R.id.ma_image3_2);
            title3_2 = itemView.findViewById(R.id.ma_title3_2);
        }
    }

    public interface onClickListener {
        void onClick(View  view, int position);
    }
    public void setOnClickListener(onClickListener clickListener){
        this.clickListener = clickListener;
    }
}
