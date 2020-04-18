package com.example.museum.Datas;

import java.util.ArrayList;
import java.util.List;

public class News {
    private Integer id;
    private String title;
    private String imgurl;
    private String content;

    public News(Integer id, String title, String imgurl, String content) {
        this.id = id;
        this.title = title;
        this.imgurl = imgurl;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title= name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public static List<News> getTestData() {
        List<News> list = new ArrayList<>();
        list.add(new News(1,"博物馆之夜1","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(2,"博物馆之夜2","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(3,"博物馆之夜3","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(4,"博物馆之夜4","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(5,"博物馆之夜5","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(6,"博物馆之夜6","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(7,"博物馆之夜7","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(8,"博物馆之夜8","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(9,"博物馆之夜9","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));
        list.add(new News(10,"博物馆之夜10","https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg","xxxx"));

        return list;

    }
}
