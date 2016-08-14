package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;

import java.util.List;

/**
 * 项目名称：suwenandroidv1
 * 类描述：
 * 创建人：陈钊
 * 创建时间：2016/8/4 11:39
 * 修改人：陈钊
 * 修改时间：2016/8/4 11:39
 * 修改备注：
 */
public class MainListPopAdapter extends AbsAdapter<String> {
    public MainListPopAdapter(Context context, int layoutRes, List<String> datas) {
        super(context, layoutRes, datas);
    }

    @Override
    public void showData(ViewHolder vHolder, String data, int position) {
       TextView mTv= (TextView) vHolder.getView(R.id.tv_list_pop);
        mTv.setText(data);
    }
}
