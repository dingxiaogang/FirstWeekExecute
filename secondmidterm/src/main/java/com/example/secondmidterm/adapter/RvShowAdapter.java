package com.example.secondmidterm.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.secondmidterm.R;
import com.example.secondmidterm.bean.MainBean;
import com.example.secondmidterm.bean.ShowBean;

import java.util.ArrayList;

public class RvShowAdapter extends RecyclerView.Adapter {
    public ArrayList<ShowBean.T1348648756099Bean> showData;
    private onClickListener clickListener;
    private onClickListener2 clickListener2;

    public RvShowAdapter(ArrayList<ShowBean.T1348648756099Bean> showData) {
        this.showData = showData;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }else if (position > 0){
            return 1;
        }else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_show_list_one, viewGroup, false);
            return new ShowViewHolderOne(inflate);
        }else if (i == 1){
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_show_list_two, viewGroup, false);
            return new ShowViewHolderTwo(inflate);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        ShowBean.T1348648756099Bean t1348648756099Bean = showData.get(i);
        if (itemViewType == 0){
            ShowViewHolderOne showViewHolderOne = (ShowViewHolderOne) viewHolder;
            Glide.with(viewHolder.itemView.getContext()).load(t1348648756099Bean.getImgsrc()).into(showViewHolderOne.imageView);
            showViewHolderOne.title.setText(t1348648756099Bean.getTitle());
            showViewHolderOne.desc.setText(t1348648756099Bean.getPtime());
        }else if (itemViewType == 1){
            ShowViewHolderTwo showViewHolderTwo = (ShowViewHolderTwo) viewHolder;
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(viewHolder.itemView.getContext()).load(t1348648756099Bean.getImgsrc()).apply(options).into(showViewHolderTwo.imageView2);
            showViewHolderTwo.title2.setText(t1348648756099Bean.getTitle());

            showViewHolderTwo.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener2 != null){
                        clickListener2.onClick(v,i);
                    }
                }
            });
        }



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
        return showData.size();
    }

    class ShowViewHolderOne extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView desc;

        public ShowViewHolderOne(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sh_image);
            title = itemView.findViewById(R.id.sh_title);
            desc = itemView.findViewById(R.id.sh_desc);
        }
    }

    class ShowViewHolderTwo extends RecyclerView.ViewHolder {
        private ImageView imageView2;
        private TextView title2;
        private ImageButton btn;

        public ShowViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.sh_image2);
            title2 = itemView.findViewById(R.id.sh_title2);
            btn = itemView.findViewById(R.id.sh_btn);
        }
    }

    public interface onClickListener {
        void onClick(View view, int position);
    }
    public void setOnClickListener(onClickListener clickListener){
        this.clickListener = clickListener;
    }
    public interface onClickListener2 {
        void onClick(View view, int position);
    }
    public void setOnClickListener2(onClickListener2 clickListener2){
        this.clickListener2 = clickListener2;
    }
}
