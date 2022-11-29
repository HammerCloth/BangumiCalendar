package com.syx.bangumiCalender.dao.impl;

import com.syx.bangumiCalender.dao.BangumiData;
import com.syx.bangumiCalender.pojo.Bangumi;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName DataFromYucTest
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/11/29 16:57
 * @Version v0.1
 **/
class DataFromYucTest {

    @Test
    void getData() {
        BangumiData data = new DataFromYuc();
        for (Bangumi i : data.getData()) {
            System.out.println(i.toString());
        }
    }


}