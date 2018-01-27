package com.example.newstest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newstest.bean.News;
import com.example.newstest.bean.NewsGson;

import java.util.List;

/**
 * Created by sl on 2018/1/24.
 */

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.ViewHolder> {

    private Context mContext;
    private List<NewsGson.News> mList;

    public LinearAdapter(Context context, List<NewsGson.News> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public LinearAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final LinearAdapter.ViewHolder holder, int position) {
        holder.title.setText(mList.get(position).getTitle());
        holder.description.setText(mList.get(position).getDescription());
        holder.time.setText(mList.get(position).getTime());
        Glide.with(mContext).load(mList.get(position).getPicUrl()).into(holder.pic);
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(mContext,NewsActivity.class);
                intent.putExtra("NewsUrl",mList.get(position).getNewUrl());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
        TextView title;
        TextView time;
        TextView description;
        LinearLayout linear;

        public ViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.new_time);
            title = (TextView) itemView.findViewById(R.id.new_title);
            description = (TextView) itemView.findViewById(R.id.new_description);
            pic = (ImageView) itemView.findViewById(R.id.new_pic);
            linear = (LinearLayout) itemView;
        }
    }
}
