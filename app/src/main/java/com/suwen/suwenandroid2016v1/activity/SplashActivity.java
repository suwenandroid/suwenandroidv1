package com.suwen.suwenandroid2016v1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.suwen.suwenandroid2016v1.R;

/**
 * 引导页的activity
 *
 * @author hongbin.niu
 * @version 3.1.1
 * @since 2016-07-30 17:23
 */
public class SplashActivity extends BaseActivity {
    private ImageView ivAd;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }

    };

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        ivAd = (ImageView) findViewById(R.id.activity_splash_iv_ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.sendEmptyMessageDelayed(0, 2000);
        //可以在这里去请求数据，可以加快首页的启动速度，这里面主要做的是更新的操作

    }

    @Override
    protected void initData() {

    }
}
