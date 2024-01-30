package com.example.newsapp;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {
    private final ArrayList<Articles> articlesArrayList;
    private Context context;

    public NewsRVAdapter(ArrayList<Articles> articlesArrayList, Context context) {
        this.articlesArrayList = articlesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
       return new NewsRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.subtitleTv.setText(articles.getDescription());
        holder.titleTv.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.newsIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,NewsDetailActivity.class);
                i.putExtra("title",articles.getTitle());
                i.putExtra("content",articles.getContent());
                i.putExtra("description",articles.getDescription());
                i.putExtra("publishedAt",articles.getPublishedAt());
                i.putExtra("url",articles.getUrl());
                i.putExtra("image",articles.getUrlToImage());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTv, subtitleTv;
        private ImageView newsIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.TVnewsheading);
            subtitleTv = itemView.findViewById(R.id.TVsubtitle);
            newsIV = itemView.findViewById(R.id.IVnews);
        }
    }
}
