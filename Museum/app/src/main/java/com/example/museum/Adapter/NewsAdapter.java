package com.example.museum.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.museum.Datas.News;
import com.example.museum.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNewsList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsName;

        public ViewHolder(View view) {
            super(view);
            newsImage = (ImageView) view.findViewById(R.id.news_image);
            newsName = (TextView) view.findViewById(R.id.news_name);
        }
    }

    public NewsAdapter() {
        mNewsList = News.getTestData();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_firstnewsview, parent,
                        false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = mNewsList.get(position);
        Glide.with(holder.itemView)
                .load(news.getImgurl())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.newsImage);

//        holder.newsImage.setImageResource(.getImageId());
        holder.newsName.setText(news.getName());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

}
