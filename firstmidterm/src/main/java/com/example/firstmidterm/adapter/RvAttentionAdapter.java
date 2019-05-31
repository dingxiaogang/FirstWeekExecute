package com.example.firstmidterm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firstmidterm.R;
import com.example.firstmidterm.bean.AttentionBean;
import com.example.firstmidterm.bean.SchoolBean;

import java.util.ArrayList;

public class RvAttentionAdapter extends RecyclerView.Adapter {
    public ArrayList<AttentionBean.RecentBean> recentBeans;
    private onClickListener clickListener;

    public RvAttentionAdapter(ArrayList<AttentionBean.RecentBean> recentBeans) {
        this.recentBeans = recentBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_attention_list, viewGroup, false);
        return new AttentionViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        AttentionViewHolder attentionViewHolder = (AttentionViewHolder) viewHolder;
        AttentionBean.RecentBean recentBean = recentBeans.get(i);
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(viewHolder.itemView.getContext()).load(recentBean.getThumbnail()).apply(options).into(attentionViewHolder.smallImageView);
        attentionViewHolder.author.setText(recentBean.getTitle());
        Glide.with(viewHolder.itemView.getContext()).load(recentBean.getThumbnail()).apply(options).into(attentionViewHolder.imageView);
        attentionViewHolder.title.setText(recentBean.getTitle());

        attentionViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
        return recentBeans.size();
    }

    class AttentionViewHolder extends RecyclerView.ViewHolder {
        private ImageView smallImageView;
        private TextView author;
        private ImageView imageView;
        private TextView title;

        public AttentionViewHolder(@NonNull View itemView) {
            super(itemView);
            smallImageView = itemView.findViewById(R.id.att_small_image);
            author = itemView.findViewById(R.id.att_author);
            imageView = itemView.findViewById(R.id.att_image);
            title = itemView.findViewById(R.id.att_title);
        }
    }

    public interface onClickListener {
        void onClick(View view, int position);
    }
    public void setOnClickListener(onClickListener clickListener){
        this.clickListener = clickListener;
    }
}
