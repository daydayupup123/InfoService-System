package com.example.museum.ui.first;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.example.museum.Adapter.ImageNetAdapter;
import com.example.museum.Adapter.NewsAdapter;
import com.example.museum.Datas.DataBean;
import com.example.museum.Datas.News;
import com.example.museum.MainActivity;
import com.example.museum.NewsActivity;
import com.example.museum.R;
import com.google.android.material.snackbar.Snackbar;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.BannerUtils;


public class FirstFragment extends Fragment implements OnPageChangeListener {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_firstpage, container, false);
        final TextView textView = root.findViewById(R.id.text_firstTitle);
        textView.setText("精选");


        final Banner banner = root.findViewById(R.id.banner);
        //设置适配器
        banner.setAdapter(new ImageNetAdapter(DataBean.getTestData()));
        //设置指示器
        banner.setIndicator(new CircleIndicator(getContext()));
        //设置点击事件

        banner.setOnBannerListener((data, position) -> {
                //转到新闻页面，并传递存储新闻的数组下标给该页面
                Intent intent = new Intent(getContext(), NewsActivity.class);
                intent.putExtra("Index",position);
                startActivity(intent);
        });
        //添加切换监听
        banner.addOnPageChangeListener(this);
        //圆角
        banner.setBannerRound(BannerUtils.dp2px(5));

        RecyclerView recyclerView = (RecyclerView)root.findViewById(R.id.recycler_firstview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        return root;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
