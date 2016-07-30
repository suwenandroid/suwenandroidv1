package com.suwen.suwenandroid2016v1.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.adapter.SuwenPageAdapter;
import com.suwen.suwenandroid2016v1.utils.CommonUtils;
import com.suwen.suwenandroid2016v1.views.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.1.1
 * @since 2016-07-30 15:15
 */
public class SuwenFragment extends BaseFragment {
    private Activity mActivity;
    private TabPageIndicator indicator;
    private ViewPager viewPager;
    private List<String> mTitles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private SuwenPageAdapter adapter;

    @Override
    protected int getContentView() {
        return R.layout.fragment_suwem;
    }


    public static SuwenFragment getInstance() {
        return new SuwenFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = super.onCreateView(inflater, container, savedInstanceState);
        initView(mRootView);
        initData();
        return mRootView;
    }

    /**
     * 初始化布局
     */
    private void initData() {
        mTitles.add("测试1");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试2");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试3");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试4");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试55");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试666");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试7777");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试88888");
        fragments.add(SuWenChildFragment.getInstance());
        mTitles.add("测试999999");
        fragments.add(SuWenChildFragment.getInstance());
        viewPager.setOffscreenPageLimit(fragments.size());
        adapter = new SuwenPageAdapter(getChildFragmentManager(), mTitles, fragments);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        setTabPagerIndicator();
    }

    /**
     * 初始化UI
     *
     * @param mRootView
     */
    private void initView(View mRootView) {
        indicator = (TabPageIndicator) mRootView.findViewById(R.id.indicator);
        viewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    private void setTabPagerIndicator() {
        indicator.setIndicatorMode(TabPageIndicator.IndicatorMode.MODE_NOWEIGHT_EXPAND_NOSAME);// 设置模式，一定要先设置模式
        indicator.setDividerColor(Color.parseColor("#00bbcf"));// 设置分割线的颜色
        indicator.setDividerPadding(CommonUtils.dip2px(mActivity, 10));
        indicator.setIndicatorColor(Color.parseColor("#43A44b"));// 设置底部导航线的颜色
        indicator.setTextColorSelected(Color.parseColor("#ffffff"));// 设置tab标题选中的颜色
        indicator.setTextColor(Color.parseColor("#999999"));// 设置tab标题未被选中的颜色
        indicator.setTextSize(CommonUtils.sp2px(mActivity, 16));// 设置字体大小
    }

}
