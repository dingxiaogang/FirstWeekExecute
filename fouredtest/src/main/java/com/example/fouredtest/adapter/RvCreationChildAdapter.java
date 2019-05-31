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

public class RvCreationChildAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<CreationChildBean.DataBean.DatasBean> datasBeans;

    public RvCreationChildAdapter(Context context, List<CreationChildBean.DataBean.DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_creation_child_list, viewGroup, false);
        return new CreationChildViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CreationChildViewHolder creationChildViewHolder = (CreationChildViewHolder) viewHolder;
        CreationChildBean.DataBean.DatasBean datasBean = datasBeans.get(i);
        Glide.with(context).load(datasBean.getEnvelopePic()).into(creationChildViewHolder.imageView);
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
            imageView = itemView.findViewById(R.id.creation_child_image);
            title = itemView.findViewById(R.id.creation_child_title);
        }
    }
}
