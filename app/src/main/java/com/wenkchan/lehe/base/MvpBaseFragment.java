package com.wenkchan.lehe.base;

import android.content.Context;

/**
 * Created by Wenk.Chan on 2016/6/17.
 */

public abstract class MvpBaseFragment<V extends IBaseView, P extends BasePresenter> extends BaseFragment {
    protected P mPresenter;


    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }else{
            throw new NullPointerException("You have not return presenter instance yet");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter.detachView();
        }

    }


    protected abstract P createPresenter();
}
