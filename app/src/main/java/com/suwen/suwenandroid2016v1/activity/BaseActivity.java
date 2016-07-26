package com.suwen.suwenandroid2016v1.activity;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.suwen.suwenandroid2016v1.dialog.CustomProgressDiolog;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private boolean activityFinish = false;
    //进度加载对话框
    private CustomProgressDiolog mProcessDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initData();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

    }

    /**
     * 需要接收消息的activity重写改方法
     * @param event
     */
    public void onEventMainThread(EventBus event) {

    }

    /**
     * @return 返回activity要加载的布局的id，必须要实现
     */
    protected abstract int getContentView();

    /**
     * 布局初始化
     */
    protected abstract void initView();

    /**
     * 数据初始化
     */
    protected abstract void initData();

    /***
     * 加载进度的时候显示进度对话框,暂时有点bug，明天搞
     *
     * @param message
     */
    protected void showLoading(String message) {
        if (isFinished())
            return;
        mProcessDialog = CustomProgressDiolog.show(this, message);
        // 注册back键清除进度对话框，后台线程仍然进行
        mProcessDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    try {
                        dialog.dismiss();
                        dialog = null;
                    } catch (Exception e) {
                    }
                }
                return false;
            }
        });
    }

    /**
     * 隐藏进度对话框
     */
    protected void dismissLoading() {
        if (mProcessDialog != null && mProcessDialog.isShowing()) {
            mProcessDialog.dismiss();
        }
    }


    /**
     * 判断activity是否已经结束
     *
     * @return
     */
    @TargetApi(17)
    public boolean isFinished() {
        if (Build.VERSION.SDK_INT >= 17) {
            return isDestroyed() || isFinishing() || activityFinish;
        } else {
            return isFinishing() || activityFinish;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityFinish = true;
        if (mProcessDialog != null && mProcessDialog.isShowing()) {
            mProcessDialog.dismiss();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

}
