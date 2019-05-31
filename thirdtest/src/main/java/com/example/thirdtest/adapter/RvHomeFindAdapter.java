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

import java.util.List;

public class RvHomeFindAdapter extends RecyclerView.Adapter {
    private List<CreationChildBean.DataBean.DatasBean> datasBeans;

    public RvHomeFindAdapter(List<CreationChildBean.DataBean.DatasBean> datasBeans) {
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_find_list, viewGroup, false);
        return new CreationChildViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CreationChildViewHolder creationChildViewHolder = (CreationChildViewHolder) viewHolder;
        CreationChildBean.DataBean.DatasBean datasBean = datasBeans.get(i);
        Glide.with(viewHolder.itemView.getContext()).load(datasBean.getEnvelopePic()).into(creationChildViewHolder.imageView);
        creationChildViewHolder.title.setText(datasBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class CreationChildViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;

        public CreationChildViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_find_image);
            title = itemView.findViewById(R.id.home_find_title);
        }
    }
}
