package com.example.thirdtest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thirdtest.R;
import com.example.thirdtest.bean.CreationChildBean;

import java.util.ArrayList;
import java.util.List;

public class RvHomeWeekAdapter extends RecyclerView.Adapter {
    private List<CreationChildBean.DataBean.DatasBean> datasBeans;

    public RvHomeWeekAdapter(List<CreationChildBean.DataBean.DatasBean> datasBeans) {
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_week_list, viewGroup, false);
        return new CreationChildViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CreationChildViewHolder creationChildViewHolder = (CreationChildViewHolder) viewHolder;
        Glide.with(viewHolder.itemView.getContext()).load(datasBeans.get(i).getEnvelopePic()).into(creationChildViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class CreationChildViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public CreationChildViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_week_image);
        }
    }
}
