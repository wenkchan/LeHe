package com.wenkchan.lehe.main;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.wenkchan.lehe.R;
import com.wenkchan.lehe.base.BaseResponse;
import com.wenkchan.lehe.base.MvpBaseActivity;
import com.wenkchan.lehe.util.RetrofitUtil;

import java.io.File;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends MvpBaseActivity<IMainView,MainPresenter> implements IMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitUtil.getInstance().getService().getJokeList("9df533138499d5ebd6f0b326b26dd981")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseResponse>() {
                    @Override
                    public void call(BaseResponse baseResponse) {
                        Log.i("haha",baseResponse.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(int code) {

    }
}
