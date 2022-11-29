package com.syx.bangumiCalender;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;

/**
 * @ClassName testDemo
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/11/29 10:28
 * @Version v0.1
 **/
public class testDemo {
    @Test
    public void testJsoup() throws IOException {
        String url = "https://yuc.wiki/202301";
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc);
    }

    @Test
    public void testJsoupGetData() throws IOException {
        String url = "https://yuc.wiki/202301";
        Document doc = Jsoup.connect(url).get();
        Element container = doc.body().child(0);
        Element main = container.child(3);
        Element content = main.child(0).child(0).child(0);
    }

    @Test
    public void testSelect() throws IOException {
        String url = "https://yuc.wiki/202301";
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.select(".post-title").text());
        Elements body = doc.select(".post-body");
        Elements bangumiItems = body.select("div[style=float:left],div[style=float:left]+div");
        Iterator<Element> iterator = bangumiItems.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println("------");
        }
    }
}
