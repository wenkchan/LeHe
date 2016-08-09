package com.wenkchan.lehe.base;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Wenk.Chan on 2016/6/17.
 */

public class BaseResponse<T> {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"某日代表单位上台领奖，站在台上意气风发得意洋洋，享受着闪光灯闪烁的快感。猛然发现台下一位认识的同行对俺指了指，好像在暗示什么？难道奖牌拿倒了，低下头观察了一下，没有呀，一切正常。下台后经过那哥们的位置，他悄悄的说了一句令俺差点当场晕倒的话：\u201c兄弟，你裤子的拉链没拉上去！\u201d","hashId":"de9c61ffa48da5ba2f40c57a362510db","unixtime":1470702231,"updatetime":"2016-08-09 08:23:51"}]}
     */

    private int error_code;
    private String reason;
    private T result;


    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }



    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
