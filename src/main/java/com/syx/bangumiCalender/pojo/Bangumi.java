package com.syx.bangumiCalender.pojo;

import lombok.Data;

import java.net.URL;

/**
 * @ClassName Bangumi
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/11/29 11:22
 * @Version v0.1
 **/
@Data
public class Bangumi {
    private String coverUrl; //封面图片
    private String titleCN; //中文标题
    private String titleJP; //日文标题
    private Type type; //番剧类型
    private String tags; //番剧标签
    private String staff; //番剧参加人员
    private String cast; //番剧卡司
    private String officialUrl; //番剧官网
    private String pvUrl; //番剧pv连接
    private String broadcast; //番剧播出时间
    private String broadcastRemarks; //番剧播出备注

    public Bangumi(String coverUrl, String titleCN, String titleJP,
                   Type type, String tags, String staff, String cast,
                   String officialUrl, String pvUrl, String broadcast,
                   String broadcastRemarks) {
        this.coverUrl = coverUrl;
        this.titleCN = titleCN;
        this.titleJP = titleJP;
        this.type = type;
        this.tags = tags;
        this.staff = staff;
        this.cast = cast;
        this.officialUrl = officialUrl;
        this.pvUrl = pvUrl;
        this.broadcast = broadcast;
        this.broadcastRemarks = broadcastRemarks;
    }

    public Bangumi() {
    }
}
