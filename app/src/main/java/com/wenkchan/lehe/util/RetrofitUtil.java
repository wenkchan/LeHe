package com.wenkchan.lehe.util;

import com.wenkchan.lehe.retrofit.JokeService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wenk.Chan on 16/7/19.
 */

public class RetrofitUtil {
    private static volatile RetrofitUtil mRetrofitUtil;
    private static JokeService jokeService;

    public static RetrofitUtil getInstance() {
        if (null == mRetrofitUtil) {
            synchronized (RetrofitUtil.class) {
                if (null == mRetrofitUtil) {
                    mRetrofitUtil = new RetrofitUtil();
                    initRetrofit();
                }
            }
        }
        return mRetrofitUtil;
    }

    private static void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://japi.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        jokeService = retrofit.create(JokeService.class);
    }

    public JokeService getService() {
        return jokeService;
    }
}
