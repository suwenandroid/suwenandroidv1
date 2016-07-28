package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class SearchHistoryAdapter extends AbsAdapter<String> {
    public SearchHistoryAdapter(Context context, int layoutRes, List<String> datas) {
        super(context, layoutRes, datas);
    }

    @Override
    public void showData(ViewHolder vHolder, String data, int position) {
        TextView name = (TextView) vHolder.getView(R.id.tv_search_text);
        name.setText(data);
    }
}
