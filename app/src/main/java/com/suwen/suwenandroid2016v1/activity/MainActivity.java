package com.suwen.suwenandroid2016v1.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.fragment.MineFragment;
import com.suwen.suwenandroid2016v1.fragment.SearchFragment;
import com.suwen.suwenandroid2016v1.fragment.SuWenChildFragment;
import com.suwen.suwenandroid2016v1.utils.BottomTabUtils;
import com.suwen.suwenandroid2016v1.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener,BottomTabUtils.BottomTabCallback {
    /**
     * 底部Tab RadioGroup
     */
    private RadioGroup mBottomTabGroup;
    private List<Fragment> mFragments;
    //title上面的字
    private TextView mTvTitle;
    //title上面的汉堡包
    private CheckBox mCbHumble;
    private BottomTabUtils bottomTabUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListener();
    }

    private void setListener() {
        mCbHumble.setOnClickListener(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setBottomTab(); //处理底部的Tab
        mTvTitle = (TextView) this.findViewById(R.id.tv_activit_title);
        mCbHumble = (CheckBox) this.findViewById(R.id.checkbox_hamble);
    }

    //设置main底部的Tab
    private void setBottomTab() {
        mBottomTabGroup = (RadioGroup) this.findViewById(R.id.group_main_tab);
        mFragments = new ArrayList<>();
        mFragments.add(SuWenChildFragment.getInstance());
        mFragments.add(SearchFragment.newInstance("", ""));
        mFragments.add(MineFragment.newInstance("", ""));
        bottomTabUtils = new BottomTabUtils(mBottomTabGroup, mFragments, getSupportFragmentManager(), R.id.mian_container,this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkbox_hamble:
                showPopWindow();
                break;
            default:
                break;
        }
    }

    private void showPopWindow() {
        if(mCbHumble.isChecked()) {
            //显示popWindow
            ToastUtils.show(mCbHumble.isChecked()+"");
        } else {
            //隐藏popWindow
            ToastUtils.show(mCbHumble.isChecked()+"");
        }
    }

    @Override
    public void BottomTabCurIndex(int index) {
        ToastUtils.show(index+"");

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
