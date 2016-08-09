package com.wenkchan.lehe.base;

/**
 * Created by Wenk.Chan on 2016/6/17.
 */

public interface IBaseView {
    void showLoading();
    void hideLoading();
    void onError(int code);
}
