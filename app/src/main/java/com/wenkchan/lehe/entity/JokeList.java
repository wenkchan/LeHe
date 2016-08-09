package com.wenkchan.lehe.entity;

import java.util.List;

/**
 * Created by Wenk.Chan on 16/8/9.
 */

public class JokeList {

    /**
     * content : 某日代表单位上台领奖，站在台上意气风发得意洋洋，享受着闪光灯闪烁的快感。猛然发现台下一位认识的同行对俺指了指，好像在暗示什么？难道奖牌拿倒了，低下头观察了一下，没有呀，一切正常。下台后经过那哥们的位置，他悄悄的说了一句令俺差点当场晕倒的话：“兄弟，你裤子的拉链没拉上去！”
     * hashId : de9c61ffa48da5ba2f40c57a362510db
     * unixtime : 1470702231
     * updatetime : 2016-08-09 08:23:51
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String content;
        private String hashId;
        private int unixtime;
        private String updatetime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public int getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(int unixtime) {
            this.unixtime = unixtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }

}
