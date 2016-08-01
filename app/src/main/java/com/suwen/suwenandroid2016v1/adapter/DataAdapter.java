package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.beans.SuwenList;

import java.util.List;

/**
 * Created by niuhongbin on 16/4/19.
 */
public class DataAdapter extends AbsAdapter<SuwenList.DataBean.DataListBean> {

    @Override
    public void showData(ViewHolder vHolder, SuwenList.DataBean.DataListBean data, int position) {
        vHolder.setText(R.id.tv_title, data.getTitle());
        vHolder.setText(R.id.tv_content, data.getContent());
        Glide.with(context).load(data.getImgUrl()).placeholder(R.drawable.default_big)
                .error(R.drawable.default_big).
                into((ImageView) vHolder.getView(R.id.iv_icon));
    }

    public DataAdapter(Context context, int layoutRes, List<SuwenList.DataBean.DataListBean> datas) {
        super(context, layoutRes, datas);
    }
}

