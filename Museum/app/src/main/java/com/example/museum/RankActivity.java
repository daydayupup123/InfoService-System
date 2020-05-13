package com.example.museum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.museum.Adapter.RankMuseumsAdapter;
import com.example.museum.Components.FilterHeadView;
import com.example.museum.Datas.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
* 排名页面
* */
public class RankActivity extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
//    private NewsAdapter_test_willbedeleted adapter;
    private RankMuseumsAdapter adapter;
    private ProgressBar progressBar;
    //防止在子线程中更新UI时程序会崩溃，添加了Handler
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            progressBar.setVisibility(View.GONE);
            if (msg.what == 1) {
                recyclerView.setAdapter(adapter) ; //UI更改操作
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        progressBar=findViewById(R.id.progressBar_rank);
        recyclerView = findViewById(R.id.recycler_rankpage);
        layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);

//        String url = "http://v.juhe.cn/toutiao/index?type=top&key=3f27f65b56ef05ccc3b25e576806f811";
//        getRankDatas(url);
        progressBar.setVisibility(View.GONE);
        adapter = new RankMuseumsAdapter();
        recyclerView.setAdapter(adapter) ;
        FilterHeadView filterHeadView = findViewById(R.id.filter);
        LinearLayout filter_item1=findViewById(R.id.zonghe);
        filter_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHeadView.hide();
            }
        });
        LinearLayout filter_item2=findViewById(R.id.cishu);
        filter_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHeadView.hide();
                String url = "http://v.juhe.cn/toutiao/index?type=top&key=3f27f65b56ef05ccc3b25e576806f811";
                getRankDatas(url);
            }
        });
        //点击上方返回键返回到上个页面
        ImageView backToHome = findViewById(R.id.backtofinding4);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void getRankDatas(String url)
    {
        List<News> newsList = new ArrayList<>();
        //         从服务器获取后台数据
        new Thread(()->{
            try{
                String str = HttpRequest.Get(url);
                String jsonData = str;
                JSONObject Jobject = new JSONObject(jsonData);
                JSONArray Jarray = Jobject.getJSONObject("result").getJSONArray("data");
                for(int i=0;i<Jarray.length();i++) {
                    JSONObject object = Jarray.getJSONObject(i);
                    newsList.add(new News(object.getString("title"), object.getString("thumbnail_pic_s"),object.getString("url")));
                }
//                adapter = new NewsAdapter_test_willbedeleted(newsList);
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);    // 将Message对象发送出去
            }catch(JSONException e){
                e.printStackTrace();
            }}).start();
    }
}
