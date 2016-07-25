package com.suwen.suwenandroid2016v1.log;

import android.util.Log;

/**
 * Created by niuhongbin on 16/4/19.
 */
public class MyLog {
    private static boolean DEBUG = true;

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }
}
