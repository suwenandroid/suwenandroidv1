package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
public class MineAdapter extends AbsAdapter<String> {
    public MineAdapter(Context context, int layoutRes, List<String> datas) {
        super(context, layoutRes, datas);
    }

    @Override
    public void showData(ViewHolder vHolder, String data, int position) {
        TextView tv = (TextView) vHolder.getView(R.id.tv_mine);
        tv.setText(data);
    }
}
