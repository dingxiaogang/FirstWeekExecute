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

public class RvThemeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ThemeBean.DataBean.DatasBean> datasBeans;

    public RvThemeAdapter(Context context, ArrayList<ThemeBean.DataBean.DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_theme_list, viewGroup, false);
        return new ThemeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ThemeViewHolder themeViewHolder = (ThemeViewHolder) viewHolder;
        ThemeBean.DataBean.DatasBean datasBean = datasBeans.get(i);
        Glide.with(context).load(datasBean.getEnvelopePic()).into(themeViewHolder.imageView);
        themeViewHolder.title.setText(datasBean.getTitle());
        themeViewHolder.niceData.setText(datasBean.getNiceDate());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class ThemeViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView niceData;

        public ThemeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.theme_rv_image);
            title = itemView.findViewById(R.id.theme_rv_title);
            niceData = itemView.findViewById(R.id.theme_rv_niceDate);
        }
    }
}
