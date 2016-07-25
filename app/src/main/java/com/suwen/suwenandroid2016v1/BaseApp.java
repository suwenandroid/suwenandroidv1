package com.suwen.suwenandroid2016v1;

import android.app.Application;
import android.view.LayoutInflater;

/**
 * Created by Administrator on 2016/7/25.
 */
public class BaseApp extends Application {
    private static BaseApp AppInstance = new BaseApp();
    public static LayoutInflater INFLATER = null;

    public BaseApp() {
    }

    public static BaseApp getBaseAppInstance() {
        return AppInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INFLATER = LayoutInflater.from(this);
    }
}
