package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.rest.model.Data;

import java.util.List;

/**
 * Created by niuhongbin on 16/4/19.
 */
public class DataAdapter extends AbsAdapter<Data> {

    @Override
    public void showData(ViewHolder vHolder, Data data, int position) {
        vHolder.setText(R.id.tv_title, data.getCatename());
        Glide.with(context).load(data.getIcon()).into((ImageView) vHolder.getView(R.id.iv_icon));
    }

    public DataAdapter(Context context, int layoutRes, List<Data> datas) {
        super(context, layoutRes, datas);
    }
}

