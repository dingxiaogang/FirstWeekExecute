package com.example.firstweekexercise.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.firstweekexercise.R;
import com.example.firstweekexercise.bean.StoryListBean;

import java.util.ArrayList;

public class RvParentListAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<StoryListBean.DataBean.DatasBean> datasBeans;

    public RvParentListAdapter(Context context, ArrayList<StoryListBean.DataBean.DatasBean> datasBeans) {
        this.context = context;
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_parent_list, viewGroup, false);
        return new ListViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ListViewHolder listViewHolder = (ListViewHolder) viewHolder;
        StoryListBean.DataBean.DatasBean datasBean = datasBeans.get(i);
        Glide.with(context).load(datasBean.getEnvelopePic()).into(listViewHolder.imageView);
        listViewHolder.title.setText(datasBean.getTitle());
        listViewHolder.author.setText(datasBean.getAuthor());
        listViewHolder.niceDate.setText(datasBean.getNiceDate());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView author;
        private TextView niceDate;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.parent_rv_image);
            title = itemView.findViewById(R.id.parent_rv_title);
            author = itemView.findViewById(R.id.parent_rv_author);
            niceDate = itemView.findViewById(R.id.parent_rv_niceDate);
        }
    }
}
