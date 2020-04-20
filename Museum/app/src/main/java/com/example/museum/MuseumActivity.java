package com.example.museum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.museum.Adapter.MuseumAdapter;
import com.example.museum.Datas.Museum;


public class MuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);
        ActionBar actionbar = getSupportActionBar();
        // 隐藏标题栏
        if (actionbar != null) {
            actionbar.hide();
        }
        SearchView searchView = (SearchView)findViewById(R.id.search_museum);
        searchView.setIconified(false);
        searchView.setSubmitButtonEnabled(true);//显示提交按钮
        searchView.onActionViewExpanded();// 当展开无输入内容的时候，没有关闭的图标
        searchView.setIconifiedByDefault(false);//默认为true在框内，设置false则在框外
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //提交按钮的点击事件
//                Toast.makeText(MuseumActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

//            @Override
//            public boolean onQueryTextChange(String newText) {
                //当输入框内容改变的时候回调
//                Log.i(TAG,"内容: " + newText);
//                return true;
//            }
        });
        //去掉搜索框的下划线
        View viewById1 = searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/search_plate",null,null));
        if (viewById1 != null) {
            viewById1.setBackgroundColor(Color.TRANSPARENT);
        }
        //去掉提交箭头下面的下划线
        View viewById2 = searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/submit_area",null,null));
        if (viewById2 != null) {
            viewById2.setBackgroundColor(Color.TRANSPARENT);
        }

        //卡片式布局显示博物馆
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_museumsviews);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        MuseumAdapter adapter= new MuseumAdapter();
        recyclerView.setAdapter(adapter);

    }
}
