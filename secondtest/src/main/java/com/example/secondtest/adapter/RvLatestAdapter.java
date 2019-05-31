package com.example.secondtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.secondtest.R;
import com.example.secondtest.bean.ThemeBean;

import java.util.ArrayList;

public class RvLatestAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ThemeBean.DataBean.DatasBean> datasBeans;

    public RvLatestAdapter(Context context, ArrayList<ThemeBean.DataBean.DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_latest_list, viewGroup, false);
        return new PopularViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PopularViewHolder themeViewHolder = (PopularViewHolder) viewHolder;
        ThemeBean.DataBean.DatasBean datasBean = datasBeans.get(i);
        Glide.with(context).load(datasBean.getEnvelopePic()).into(themeViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class PopularViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.latest_rv_image);
        }
    }
}
