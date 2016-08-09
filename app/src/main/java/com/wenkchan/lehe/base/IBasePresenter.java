package com.wenkchan.lehe.base;

/**
 * Created by Wenk.Chan on 2016/6/17.
 */

public interface IBasePresenter<V extends IBaseView> {

      void attachView(V view);


     void detachView();
}
