package com.wenkchan.lehe.base;

import com.google.gson.Gson;

/**
 * Created by Wenk.Chan on 2016/6/24.
 *
 */

public class BaseRequest {
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
