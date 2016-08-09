package com.wenkchan.lehe.retrofit;


import com.wenkchan.lehe.base.BaseResponse;
import com.wenkchan.lehe.entity.JokeList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Wenk.Chan on 16/8/9.
 */

public interface JokeService {
    @GET("joke/content/text.from")
    Observable<BaseResponse<JokeList>> getJokeList(@Query("key") String key);
}
