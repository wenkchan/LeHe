package com.wenkchan.lehe.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by chenwenkun on 2016/4/19.
 * Toast工具
 */
public class T {


    private T() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static Toast mToast;

    @SuppressLint("ShowToast")
    private static void getInstance(Context context) {
        if (null == mToast) {
            synchronized (T.class) {
                if (null == mToast) {
                    mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
                }
            }
        }
    }


    private static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow) {
            getInstance(context);
            mToast.setText(message);
            mToast.show();
        }

    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param res
     */
    public static void showShort(Context context, int res) {
        if (isShow) {
            getInstance(context);
            mToast.setText(context.getString(res));
            mToast.show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow) {
            getInstance(context);
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.show();
        }

    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param res
     */
    public static void showLong(Context context, int res) {
        if (isShow) {
            getInstance(context);
            mToast.setText(context.getString(res));
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow) {
            getInstance(context);
            mToast.setText(message);
            mToast.setDuration(duration);
            mToast.show();

        }
        Toast.makeText(context, message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (isShow) {
            getInstance(context);
            mToast.setText(message + "");
            mToast.setDuration(duration);
            mToast.show();
        }
    }

}