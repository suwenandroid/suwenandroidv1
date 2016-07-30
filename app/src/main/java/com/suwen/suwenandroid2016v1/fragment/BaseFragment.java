package com.suwen.suwenandroid2016v1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/25.
 */
public abstract class BaseFragment extends Fragment {
    protected View mRootView;

    /**
     * @return 返回activity要加载的布局的id，必须要实现
     */
    protected abstract int getContentView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
            return mRootView;
        }
        mRootView = inflater.inflate(getContentView(), container, false);
        return mRootView;
    }
}
