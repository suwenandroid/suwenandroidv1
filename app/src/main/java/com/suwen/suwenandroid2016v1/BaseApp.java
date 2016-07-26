package com.suwen.suwenandroid2016v1;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

/**
 * Created by Administrator on 2016/7/25.
 */
public class BaseApp extends Application {
    private static BaseApp AppInstance;
    public static Context context;
    public static LayoutInflater INFLATER = null;

    public BaseApp() {
    }

    public static BaseApp getBaseAppInstance() {
        if (AppInstance == null) {
            AppInstance = new BaseApp();
        }
        return AppInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INFLATER = LayoutInflater.from(this);
        AppInstance = this;
        context = this;
    }
}
