package com.wenkchan.lehe.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class MvpBaseActivity<V extends IBaseView, P extends BasePresenter> extends BaseActivity {
    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        } else {
            throw new NullPointerException("You have not return presenter instance yet");
        }
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    protected abstract P createPresenter();
}
