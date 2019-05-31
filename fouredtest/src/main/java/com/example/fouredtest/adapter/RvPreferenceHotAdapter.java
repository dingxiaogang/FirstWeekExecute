package com.example.fouredtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fouredtest.R;
import com.example.fouredtest.bean.CreationChildBean;

import java.util.List;

public class RvPreferenceHotAdapter extends RecyclerView.Adapter {
    private List<CreationChildBean.DataBean.DatasBean> datasBeans;

    public RvPreferenceHotAdapter(List<CreationChildBean.DataBean.DatasBean> datasBeans) {
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_prefercent_hot_list, viewGroup, false);
        return new CreationChildViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CreationChildViewHolder creationChildViewHolder = (CreationChildViewHolder) viewHolder;
        CreationChildBean.DataBean.DatasBean datasBean = datasBeans.get(i);
        Glide.with(viewHolder.itemView.getContext()).load(datasBean.getEnvelopePic()).into(creationChildViewHolder.imageView);
        creationChildViewHolder.author.setText(datasBean.getAuthor());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class CreationChildViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView author;

        public CreationChildViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.preference_hot_image);
            author = itemView.findViewById(R.id.preference_hot_author);
        }
    }
}
