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

public class GvStoryAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<Integer> imagePaths;
    private ArrayList<String> titles;

    public GvStoryAdapter(Context context, ArrayList<Integer> imagePaths, ArrayList<String> titles) {
        this.context = context;
        this.imagePaths = imagePaths;
        this.titles = titles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_story_gridview, viewGroup, false);
        return new GridViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        GridViewHolder listViewHolder = (GridViewHolder) viewHolder;
        Glide.with(context).load(imagePaths.get(i)).into(listViewHolder.imageView);
        listViewHolder.title.setText(titles.get(i));

    }

    @Override
    public int getItemCount() {
        return imagePaths.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.story_gv_image);
            title = itemView.findViewById(R.id.story_gv_title);
        }
    }
}
