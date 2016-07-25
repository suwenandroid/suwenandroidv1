package com.suwen.suwenandroid2016v1;

import android.app.Application;

/**
 * Created by Administrator on 2016/7/25.
 */
public class BaseApp extends Application {
    private static BaseApp AppInstance = new BaseApp();
    public BaseApp() {}

    public static BaseApp getBaseAppInstance () {
        return AppInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
