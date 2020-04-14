package com.example.museum.Adapter;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.museum.Datas.DataBean;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;
import com.example.museum.R;
public class ImageNetAdapter extends BannerAdapter<DataBean,ImageHolder> {

    public ImageNetAdapter(List<DataBean> mDatas) {
        super(mDatas);
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) BannerUtils.getView(parent, R.layout.banner_image);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, DataBean data, int position, int size) {

        Glide.with(holder.itemView)
                .load(data.imageUrl)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.imageView);
        Log.i("ImageNetAdapter", "onBindView ");
    }

}
