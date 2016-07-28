package com.suwen.suwenandroid2016v1.anim;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Description here.
 * 首页广告切换效果的动画
 * @author niuhongbin
 * @version ${VERSION}
 * @since 2016-06-29 16:57
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.8f;
    private static final float MIN_ALPHA = 0.5f;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    public void transformPage(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        } else if (position == 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setScaleY(1);
            view.setAlpha(1);
        } else if (position <= 1) { // (0,1]
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(position));
            float alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA)
                    * (1 - Math.abs(position));
            view.setScaleY(scaleFactor);
            view.setAlpha(alphaFactor);
        } else {
            // This page is way off-screen to the right.
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        }
    }
}