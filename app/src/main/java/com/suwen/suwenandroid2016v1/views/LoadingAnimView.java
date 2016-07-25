package com.suwen.suwenandroid2016v1.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.suwen.suwenandroid2016v1.BaseApp;
import com.suwen.suwenandroid2016v1.R;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.0
 * @since 2016-07-25 23:16
 */
public class LoadingAnimView extends LinearLayout {
    private ImageView mImg;
    private AnimationDrawable mAnimDrawable;

    public LoadingAnimView(Context context) {
        super(context);
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public LoadingAnimView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        View view = BaseApp.INFLATER.inflate(R.layout.loading_anim_view, this);
        mImg = (ImageView) view.findViewById(R.id.iv_loading_anim);
        startLoadingAnim();
    }

    private void startLoadingAnim() {
        mAnimDrawable = (AnimationDrawable) mImg.getDrawable();
        mAnimDrawable.start();
    }

    private void stopLoadingAnim() {
        if (mAnimDrawable == null) {
            mAnimDrawable = (AnimationDrawable) mImg.getDrawable();
        }
        mAnimDrawable.stop();
    }

    @Override
    public void setVisibility(int visible) {
        if (visible == View.VISIBLE) {
            startLoadingAnim();
        } else {
            stopLoadingAnim();
        }
        super.setVisibility(visible);
    }

}
