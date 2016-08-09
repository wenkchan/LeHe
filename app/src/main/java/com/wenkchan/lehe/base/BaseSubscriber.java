package com.wenkchan.lehe.base;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Wenk.Chan on 16/8/9.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException) {
            handleErrorMsg(e.getMessage());
        } else if (e instanceof SocketTimeoutException) {
            handleErrorMsg(e.getMessage());
        }
        if (e instanceof HttpException) {

        }
        handleErrorMsg(e.getMessage());
    }

    @Override
    public void onNext(T t) {

    }

    public abstract void handleErrorMsg(String msg);
}
