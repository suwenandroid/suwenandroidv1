package com.suwen.suwenandroid2016v1.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.beans.SuwenList;
import com.suwen.suwenandroid2016v1.utils.SysUtil;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.1.1
 * @since 2016-08-14 21:44
 */
public class DetailActivity extends BaseActivity {
    private SuwenList.DataBean.DataListBean dataListBean = null;
    private LinearLayout llContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataListBean = (SuwenList.DataBean.DataListBean) getIntent().getBundleExtra("data").getSerializable("data");
        initView();
        initData();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        llContent = (LinearLayout) findViewById(R.id.ll_content);
    }

    @Override
    protected void initData() {
        if (dataListBean != null) {
            setContent();
            setContent();
            setContent();
        }
    }

    private void setContent() {
        ImageView imageView = new ImageView(getApplicationContext());
        Glide.with(getApplicationContext()).load(dataListBean.getImgUrl())
                .placeholder(R.drawable.default_big)
                .error(R.drawable.default_big)
                .fitCenter()
                .into(imageView);
        int width = SysUtil.getScreenWidth(getApplicationContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(width, width * 3 / 4));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        llContent.addView(imageView);
        TextView textView = new TextView(getApplicationContext());
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16);
        textView.setText(dataListBean.getTitle());
        llContent.addView(textView);
        TextView tvContent = new TextView(getApplicationContext());
        tvContent.setTextColor(Color.GRAY);
        tvContent.setTextSize(14);
        tvContent.setText(dataListBean.getContent());
        llContent.addView(tvContent);
    }
}
