package com.suwen.suwenandroid2016v1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.suwen.suwenandroid2016v1.fragment.SuwenFragment;

import java.util.List;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.1.1
 * @since 2016-07-30 15:45
 */
public class SuwenPageAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitles;
    private List<Fragment> mFragment;

    public SuwenPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public SuwenPageAdapter(FragmentManager fm, List<String> mTitles, List<Fragment> mFragment) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragment = mFragment;
    }

    @Override
    public Fragment getItem(int position) {
        if (mFragment.get(position) != null) {
            return mFragment.get(position);
        } else {
            return SuwenFragment.getInstance();
        }

    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }


}