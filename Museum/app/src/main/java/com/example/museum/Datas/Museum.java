package com.example.museum.Datas;

import java.util.ArrayList;
import java.util.List;

public class Museum {
    Integer mid;
    String imgurl;
    String name;

    public Museum(Integer mid, String imgurl, String name) {
        this.mid = mid;
        this.imgurl = imgurl;
        this.name = name;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static List<Museum> getTestData() {
        List<Museum> list = new ArrayList<>();
        list.add(new Museum(1,"https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg", "故宫博物馆"));
        list.add(new Museum(2,"http://39.98.107.127:8080/resource/news/image/1.jpeg", "南口博物馆"));
        list.add(new Museum(3,"https://img.zcool.cn/community/013c7d5e27a174a80121651816e521.jpg", "hello3"));
        list.add(new Museum(4,"https://img.zcool.cn/community/01b8ac5e27a173a80120a895be4d85.jpg", "hello4"));
        list.add(new Museum(5,"https://img.zcool.cn/community/01a85d5e27a174a80120a895111b2c.jpg", "hello5"));
        list.add(new Museum(6,"https://img.zcool.cn/community/01085d5e27a174a80120a8958791c4.jpg", "hello6"));
        list.add(new Museum(7,"https://img.zcool.cn/community/01f8735e27a174a8012165188aa959.jpg", "hello7"));

        return list;

    }
}
