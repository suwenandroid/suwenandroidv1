package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.widget.ImageView;
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
        ImageView img = (ImageView) vHolder.getView(R.id.img_mine);
        switch (position) {
            case 0:
                img.setBackgroundResource(R.mipmap.userinfo01);
                break;
            case 1:
                img.setBackgroundResource(R.mipmap.userinfo02);
                break;
            case 2:
                img.setBackgroundResource(R.mipmap.userinfo03);
                break;
            case 3:
                img.setBackgroundResource(R.mipmap.userinfo04);
                break;
            case 4:
                img.setBackgroundResource(R.mipmap.userinfo05);
                break;
            default:
                break;
        }
        tv.setText(data);
    }
}
