package com.suwen.suwenandroid2016v1.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.adapter.MainListPopAdapter;
import com.suwen.suwenandroid2016v1.fragment.MineFragment;
import com.suwen.suwenandroid2016v1.fragment.SearchFragment;
import com.suwen.suwenandroid2016v1.fragment.SuWenChildFragment;
import com.suwen.suwenandroid2016v1.log.MyLog;
import com.suwen.suwenandroid2016v1.utils.BottomTabUtils;
import com.suwen.suwenandroid2016v1.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, BottomTabUtils.BottomTabCallback {
    public static final String TAG = "MainActivity";
    private Context mContext;
    /**
     * 底部Tab RadioGroup
     */

    //title上面的字
    private TextView mTvTitle;
    //title上面的汉堡包
    private CheckBox mCbHumble;
    private BottomTabUtils bottomTabUtils;
    private ListView mHumbleList;
    private MainListPopAdapter mPopAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListener();
    }

    private void setListener() {
      //  mCbHumble.setOnClickListener(this);
        mCbHumble.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showPopWindow();
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTvTitle = (TextView) this.findViewById(R.id.tv_activit_title);
        mCbHumble = (CheckBox) this.findViewById(R.id.checkbox_hamble);
        mHumbleList = (ListView) this.findViewById(R.id.lv_humble);
        mPopAdapter = new MainListPopAdapter(getApplication(),R.layout.item_main_listpopwindow,Arrays.asList(getResources().getStringArray(R.array.array_main_humble)));
        mHumbleList.setAdapter(mPopAdapter);
    }

    //设置main底部的Tab
    private void setBottomTab() {
        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(SuWenChildFragment.getInstance());
        mFragments.add(SearchFragment.newInstance("", ""));
        mFragments.add(MineFragment.newInstance("", ""));
        bottomTabUtils = new BottomTabUtils((RadioGroup) this.findViewById(R.id.group_main_tab), mFragments, getSupportFragmentManager(), R.id.mian_container, this);
    }

    @Override
    protected void initData() {
        setBottomTab(); //处理底部的Tab
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

    }

    private void showPopWindow() {
        if (mCbHumble.isChecked()) {
            //显示popWindow
           mHumbleList.setVisibility(View.VISIBLE);
        } else {
            //隐藏popWindow
            mHumbleList.setVisibility(View.GONE);
        }
    }

    @Override
    public void BottomTabCurIndex(int index) {
        setTitleText(index);
        mCbHumble.setChecked(false);

    }

    private void setTitleText(int index) {
        String[] stringArray = getResources().getStringArray(R.array.array_title_name);
        if (stringArray != null) {
            String str = stringArray[index];
            if (!TextUtils.isEmpty(str)) {
                mTvTitle.setText(str);
            }
        } else {
            MyLog.d(TAG, "get main title text is null");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        bottomTabUtils.unRegistBottomTabCallback();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomTabUtils.registBottomTabCallback(this);
    }
}
