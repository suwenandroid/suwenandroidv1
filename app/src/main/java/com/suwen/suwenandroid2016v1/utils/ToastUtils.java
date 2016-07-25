package com.suwen.suwenandroid2016v1.utils;

import android.widget.Toast;

import com.suwen.suwenandroid2016v1.BaseApp;

/**
 * Created by niuhongbin on 16/4/19.
 */
public class ToastUtils {
    /**
     * toast 帮助类
     * @param msg
     */
    public static void show(String msg) {
        Toast.makeText(BaseApp.getBaseAppInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}
