package com.suwen.suwenandroid2016v1.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.fragment.MineFragment;
import com.suwen.suwenandroid2016v1.fragment.SearchFragment;
import com.suwen.suwenandroid2016v1.fragment.SuwenFragment;
import com.suwen.suwenandroid2016v1.utils.BottomTabUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    /**
     * 底部Tab RadioGroup
     */
    private RadioGroup mBottomTabGroup;
    private List<Fragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setBottomTab(); //处理底部的Tab
    }

    //设置main底部的Tab
    private void setBottomTab() {
        mBottomTabGroup = (RadioGroup) this.findViewById(R.id.group_main_tab);
        mFragments = new ArrayList<>();
        mFragments.add(SuwenFragment.getInstance());
        mFragments.add(SearchFragment.newInstance("", ""));
        mFragments.add(MineFragment.newInstance("", ""));
        new BottomTabUtils(mBottomTabGroup, mFragments, getSupportFragmentManager(), R.id.mian_container);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
