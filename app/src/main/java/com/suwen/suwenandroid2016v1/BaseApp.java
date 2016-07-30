package com.suwen.suwenandroid2016v1;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;

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
        //友盟设置成debug调试防止数据污染
        MobclickAgent.setDebugMode(false);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.enable();
        String device_token = UmengRegistrar.getRegistrationId(this);
        Log.d("device_token","===="+device_token);
        INFLATER = LayoutInflater.from(this);
        AppInstance = this;
        context = this;
    }
}
