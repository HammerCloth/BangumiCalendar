package com.syx.bangumiCalender.dao.impl;

import com.syx.bangumiCalender.dao.BangumiData;
import com.syx.bangumiCalender.pojo.Bangumi;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName DataFromYuc
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/11/29 12:02
 * @Version v0.1
 **/
public class DataFromYuc implements BangumiData {
    private String YUC_URL = "https://yuc.wiki/202301";

    @Override
    public List<Bangumi> getData() {

    }

    //重试计数器
    private int count = 0;

    /**
     * 通过多次重试直到获取正确的结果
     *
     * @return
     */
    private Document getDocument() {
        try {
            Document document = Jsoup.connect(YUC_URL).get();
            count = 0;
            return document;
        } catch (IOException e) {
            count++;
            System.out.println("请求失败，重试第== " + count + " ==次");
            if (count <= 10) return getDocument();
        }
        return null;
    }
}
