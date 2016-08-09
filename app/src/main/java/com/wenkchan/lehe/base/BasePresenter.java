package com.wenkchan.lehe.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Wenk.Chan on 2016/6/17.
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    protected Reference<V> mViewRef;
    protected CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    protected V getView() {
        return mViewRef.get();
    }


    @Override
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
            mCompositeSubscription.unsubscribe();

        }
    }


}
