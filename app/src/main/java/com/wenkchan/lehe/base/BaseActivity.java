package com.wenkchan.lehe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.wenkchan.lehe.util.ActivityUtil;


/**
 * Created by Wenk.Chan on 2016/6/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private Fragment mCurrentFragment;

    protected void switchFragment(int layoutId, Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (mCurrentFragment == null) {
            ft.add(layoutId, fragment).commit();
        } else if (mCurrentFragment != fragment) {
            if (!fragment.isAdded()) {
                ft.hide(mCurrentFragment).add(layoutId, fragment).commit();
            } else {
                ft.hide(mCurrentFragment).show(fragment).commit();
            }
        }
        mCurrentFragment = fragment;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityUtil.getInstance().addActivity(this);
        mContext = this;
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        ActivityUtil.getInstance().finishActivity(this);
        super.onDestroy();
    }
}
