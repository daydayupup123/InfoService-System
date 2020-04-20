package com.example.museum.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.museum.Datas.Museum;
import com.example.museum.R;

import java.util.List;

import static android.view.Gravity.CENTER;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.ViewHolder> {

    private List<Museum> museumList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView museumImage;
        TextView museumName;

        public ViewHolder(View view) {
            super(view);
            museumImage = (ImageView) view.findViewById(R.id.museum_image);
            museumName = (TextView) view.findViewById(R.id.museum_name);
        }
    }

    public MuseumAdapter() {
        museumList = Museum.getTestData();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_museumsview, parent,
                        false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Museum museum = museumList.get(position);
        Glide.with(holder.itemView)
                .load(museum.getImgurl())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.museumImage);

//        holder.newsImage.setImageResource(.getImageId());
        holder.museumName.setText(museum.getName());
    }

    @Override
    public int getItemCount() {
        return museumList.size();
    }

}
