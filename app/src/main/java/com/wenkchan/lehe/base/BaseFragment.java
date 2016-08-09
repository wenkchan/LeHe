package com.wenkchan.lehe.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;

/**
 * Created by Wenk.Chan on 2016/6/24.
 */

public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    private Fragment mCurrentFragment;

    protected void switchFragment(int layoutId, Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
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
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

}
