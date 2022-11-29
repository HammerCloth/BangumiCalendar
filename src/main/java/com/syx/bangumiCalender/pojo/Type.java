package com.syx.bangumiCalender.pojo;

import lombok.Data;

/**
 * @ClassName Type
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/11/29 11:29
 * @Version v0.1
 **/
public enum Type {
    Original("原创动画"),
    Cartoon("漫画改编"),
    Novel("小说改编"),
    Game("游戏改编"),
    Other("其他题材改编");
    private String name;

    private Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType(String name) {
        switch (name) {
            case "原创动画":
                return Original;
            case "漫画改编":
                return Cartoon;
            case "小说改编":
                return Novel;
            case "游戏改编":
                return Game;
            default:
                return Other;
        }
    }
}
