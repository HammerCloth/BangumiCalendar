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
    private String titleCN;
    private String titleJP;
    private Type type;
    private String tags;
    private String staff;
    private String cast;
    private String officialUrl;
    private String pvUrl;
    private String broadcast;
}
