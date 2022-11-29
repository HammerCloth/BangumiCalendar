package com.syx.bangumiCalender.dao.impl;

import com.syx.bangumiCalender.dao.BangumiData;
import com.syx.bangumiCalender.pojo.Bangumi;
import com.syx.bangumiCalender.pojo.Type;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        Document document = getDocument();
        return ParseDocument(document);
    }

    private List<Bangumi> ParseDocument(Document doc) {
        System.out.println(doc.select(".post-title").text());
        Elements body = doc.select(".post-body");
        Elements bangumiItems = body.select("div[style=float:left],div[style=float:left]+div");
        Iterator<Element> iterator = bangumiItems.iterator();
        List<Bangumi> list = new ArrayList<>();
        while (iterator.hasNext()) {
            Element sideDiv = iterator.next();
            String coverUrl = sideDiv.select("img").attr("src");//番剧封面

            Element div = iterator.next();
            int sequenceSize = 10;
            String titleCN = div.select(genSequence("p.title_cn_r", sequenceSize)).text();
            String titleJP = div.select(genSequence("p.title_jp_r", sequenceSize)).text();
            String type = div.select(genSequence("td.type_b_r", sequenceSize)).text();
            String tags = div.select(genSequence("td.type_tag_r", sequenceSize)).text();
            String staff = div.select(genSequence("td.staff_r", sequenceSize)).text();
            String casts = div.select(genSequence("td.cast_r", sequenceSize)).text();
            String broadcast = div.select(genSequence("p.broadcast_r", sequenceSize)).text();
            String broadcaseRemark = div.select(genSequence("p.broadcast_ex_r", sequenceSize)).text();

            Bangumi temp = new Bangumi(
                    coverUrl, titleCN, titleJP,
                    Type.getType(type), tags, staff, casts,
                    null, null, broadcast, broadcaseRemark);

            list.add(temp);
        }
        return list;
    }

    private String genSequence(String patten, int size) {
        StringBuffer res = new StringBuffer(patten);
        for (int i = 1; i <= size; i++) {
            res.append(",");
            res.append(patten);
            res.append(i + "");
        }
        return res.toString();
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
