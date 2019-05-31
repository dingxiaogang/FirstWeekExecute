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
import com.example.secondmidterm.bean.CollectBean;
import com.example.secondmidterm.bean.ShowBean;

import java.util.ArrayList;

public class RvCollectAdapter extends RecyclerView.Adapter {
    public ArrayList<CollectBean> collectData;
    private onClickListener clickListener;

    public RvCollectAdapter(ArrayList<CollectBean> collectData) {
        this.collectData = collectData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_collect_list, viewGroup, false);
        return new CollectViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        CollectBean collectBean = collectData.get(i);

        CollectViewHolder collectViewHolder = (CollectViewHolder) viewHolder;
        Glide.with(viewHolder.itemView.getContext()).load(collectBean.getImagePath()).into(collectViewHolder.imageView);
        collectViewHolder.title.setText(collectBean.getTitle());
        collectViewHolder.desc.setText(collectBean.getDesc());


        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.onClick(v,i);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return collectData.size();
    }

    class CollectViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView desc;

        public CollectViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.coll_image);
            title = itemView.findViewById(R.id.coll_title);
            desc = itemView.findViewById(R.id.coll_desc);
        }
    }

    public interface onClickListener {
        void onClick(View view, int position);
    }

    public void setOnClickListener(onClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
