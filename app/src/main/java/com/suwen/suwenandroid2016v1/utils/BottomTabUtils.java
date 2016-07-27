package com.suwen.suwenandroid2016v1.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * 项目名称：suwenandroidv1
 * 类描述：
 * 创建人：陈钊
 * 创建时间：2016/7/27 11:14
 * 修改人：陈钊
 * 修改时间：2016/7/27 11:14
 * 修改备注：
 */
public class BottomTabUtils implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private List<Fragment> mFragments;
    private FragmentManager mFragmentmgr;
    private int mContainerId;

    public BottomTabUtils(RadioGroup mRadioGroup, List<Fragment> mFragments, FragmentManager mManager, int mContainerId) {
        this.mRadioGroup = mRadioGroup;
        this.mFragments = mFragments;
        this.mFragmentmgr = mManager;
        this.mContainerId = mContainerId;
        mRadioGroup.setOnCheckedChangeListener(this);
        ((RadioButton) mRadioGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < group.getChildCount(); i++) {
            if (group.getChildAt(i).getId() == checkedId) {
                Fragment mFragment = mFragments.get(i);
                FragmentTransaction transaction = obtainFragmentTransaction(i);
                if (!mFragment.isAdded()) {
                    transaction.add(mContainerId, mFragment).commit();
                }
                showFragment(i);
            }
        }
    }

    private void showFragment(int index) {
        for (int i = 0; i < mFragments.size(); i++) {
            FragmentTransaction ft = mFragmentmgr.beginTransaction();
            if (i == index) {
                ft.show(mFragments.get(index));
            } else {
                ft.hide(mFragments.get(i));
            }
            ft.commit();
        }
    }

    /**
     * 获取一个带动画的transaction
     *
     * @param index
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int index) {
        FragmentTransaction mTransaction = mFragmentmgr.beginTransaction();
        // 设置切换动画
//        if (index > currentTab) {
//            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
//        } else {
//            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
//        }
        return mTransaction;
    }
}
