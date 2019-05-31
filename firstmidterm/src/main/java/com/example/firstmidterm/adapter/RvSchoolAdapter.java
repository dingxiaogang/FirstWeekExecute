package com.example.firstmidterm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstmidterm.R;
import com.example.firstmidterm.bean.SchoolBean;

import java.util.ArrayList;

public class RvSchoolAdapter extends RecyclerView.Adapter {
    public ArrayList<SchoolBean.NewslistBean> newslistBeans;
    private onClickListener clickListener;

    public RvSchoolAdapter(ArrayList<SchoolBean.NewslistBean> newslistBeans) {
        this.newslistBeans = newslistBeans;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position % 4){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case 0:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_school_list_one, viewGroup, false);
                return new SchoolViewHolderOne(inflate);
            case 1:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_school_list_two, viewGroup, false);
                return new SchoolViewHolderTwo(inflate2);
            case 2:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_school_list_three, viewGroup, false);
                return new SchoolViewHolderThree(inflate3);
            case 3:
                View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_school_list_four, viewGroup, false);
                return new SchoolViewHolderFour(inflate4);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        SchoolBean.NewslistBean newslistBean = newslistBeans.get(i);
        switch (itemViewType){
            case 0:
                SchoolViewHolderOne schoolViewHolderOne = (SchoolViewHolderOne) viewHolder;
                Glide.with(viewHolder.itemView.getContext()).load(newslistBean.getPicUrl()).into(schoolViewHolderOne.imageView);
                schoolViewHolderOne.title.setText(newslistBean.getTitle());
                break;
            case 1:
                SchoolViewHolderTwo schoolViewHolderTwo = (SchoolViewHolderTwo) viewHolder;
                Glide.with(viewHolder.itemView.getContext()).load(newslistBean.getPicUrl()).into(schoolViewHolderTwo.imageView2_1);
                Glide.with(viewHolder.itemView.getContext()).load(newslistBean.getPicUrl()).into(schoolViewHolderTwo.imageView2_2);
                schoolViewHolderTwo.title2.setText(newslistBean.getTitle());
                break;
            case 2:
                SchoolViewHolderThree schoolViewHolderThree = (SchoolViewHolderThree) viewHolder;
                Glide.with(viewHolder.itemView.getContext()).load(newslistBean.getPicUrl()).into(schoolViewHolderThree.imageView3);
                schoolViewHolderThree.title3.setText(newslistBean.getTitle());
                break;
            case 3:
                SchoolViewHolderFour schoolViewHolderFour = (SchoolViewHolderFour) viewHolder;
                Glide.with(viewHolder.itemView.getContext()).load(newslistBean.getPicUrl()).into(schoolViewHolderFour.imageView4);
                schoolViewHolderFour.title4.setText(newslistBean.getTitle());
                break;
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
        return newslistBeans.size();
    }

    class SchoolViewHolderOne extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;

        public SchoolViewHolderOne(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sch_image);
            title = itemView.findViewById(R.id.sch_title);
        }
    }

    class SchoolViewHolderTwo extends RecyclerView.ViewHolder {
        private ImageView imageView2_1;
        private ImageView imageView2_2;
        private TextView title2;

        public SchoolViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            imageView2_1 = itemView.findViewById(R.id.sch_image2_1);
            imageView2_2 = itemView.findViewById(R.id.sch_image2_2);
            title2 = itemView.findViewById(R.id.sch_title2);
        }
    }

    class SchoolViewHolderThree extends RecyclerView.ViewHolder {
        private ImageView imageView3;
        private TextView title3;

        public SchoolViewHolderThree(@NonNull View itemView) {
            super(itemView);
            imageView3 = itemView.findViewById(R.id.sch_image3);
            title3 = itemView.findViewById(R.id.sch_title3);
        }
    }

    class SchoolViewHolderFour extends RecyclerView.ViewHolder {
        private ImageView imageView4;
        private TextView title4;

        public SchoolViewHolderFour(@NonNull View itemView) {
            super(itemView);
            imageView4 = itemView.findViewById(R.id.sch_image4);
            title4 = itemView.findViewById(R.id.sch_title4);
        }
    }

    public interface onClickListener {
        void onClick(View view, int position);
    }
    public void setOnClickListener(onClickListener clickListener){
        this.clickListener = clickListener;
    }
}
