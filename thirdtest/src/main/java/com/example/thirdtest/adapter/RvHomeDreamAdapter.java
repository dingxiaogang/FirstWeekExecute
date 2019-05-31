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

import java.util.ArrayList;

public class RvHomeDreamAdapter extends RecyclerView.Adapter {
    private ArrayList<Integer> dreamPath;
    private ArrayList<String> dreamTilte;

    public RvHomeDreamAdapter(ArrayList<Integer> dreamPath, ArrayList<String> dreamTilte) {
        this.dreamPath = dreamPath;
        this.dreamTilte = dreamTilte;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_dream_list, viewGroup, false);
        return new CreationChildViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CreationChildViewHolder creationChildViewHolder = (CreationChildViewHolder) viewHolder;
        Glide.with(viewHolder.itemView.getContext()).load(dreamPath.get(i)).into(creationChildViewHolder.imageView);
        creationChildViewHolder.title.setText(dreamTilte.get(i));
    }

    @Override
    public int getItemCount() {
        return dreamPath.size();
    }

    class CreationChildViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;

        public CreationChildViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.home_image);
            title = itemView.findViewById(R.id.home_title);
        }
    }
}
