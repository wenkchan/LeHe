package com.wenkchan.lehe.util;

/**
 * Created by wenkchan on 4/22/16.
 * Activity管理工具
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Stack;

public class ActivityUtil {
    private static Stack<Activity> mActivityStack;
    private volatile static ActivityUtil mInstance;

    private ActivityUtil() {

    }

    /**
     * 单一实例
     */
    public static ActivityUtil getInstance() {
        if (null == mInstance) {
            synchronized (ActivityUtil.class) {
                if (null == mInstance) {
                    mInstance = new ActivityUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = mActivityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = mActivityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (null != mActivityStack.get(i)) {
                mActivityStack.get(i).finish();
            }
        }
        mActivityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

    /**
     * 启动一个Activity
     *
     * @param context
     * @param cls
     */
    public void startActivity(Context context, Class cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);

    }

    /**
     * 启动一个Activity
     *
     * @param context
     * @param cls
     */
    public void startActivity(Context context, Class cls, Bundle data) {
        Intent intent = new Intent(context, cls);
        if (data != null) {
            intent.putExtras(data);
        }
        context.startActivity(intent);

    }

    /**
     * 启动一个Activity
     *
     * @param context
     * @param cls
     */
    public void startActivityForResult(Context context, Class cls, int requestCode) {
        Intent intent = new Intent(context, cls);
        ((Activity) context).startActivityForResult(intent, requestCode);

    }

    /**
     * 启动一个Activity
     *
     * @param context
     * @param cls
     */
    public void startActivityForResult(Context context, Class cls, Bundle data, int requestCode) {
        Intent intent = new Intent(context, cls);
        if (data != null) {
            intent.putExtras(data);
        }
        ((Activity) context).startActivityForResult(intent, requestCode);

    }

}
