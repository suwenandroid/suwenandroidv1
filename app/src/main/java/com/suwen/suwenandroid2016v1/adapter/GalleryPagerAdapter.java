package com.suwen.suwenandroid2016v1.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.beans.Advert;
import com.suwen.suwenandroid2016v1.log.MyLog;

import java.util.List;


/**
 * 首页头部广告的适配器
 *
 * @author niuhongbin
 * @version v3.0.0
 * @since 2016-06-30 9:35
 */

public class GalleryPagerAdapter extends PagerAdapter {
    private List<Advert> mDatas;
    private Context mContext;
    private int mPagerWidth = 0;
    private static final int DEFAULT_WIDTH_HEIGHT = 600;
    private static final int SCREEN_WIDTH_MAX = 5;
    private static final int PAGE_WIDTH = 4;
    private String TAG = getClass().getSimpleName();

    /**
     * 构造函数
     *
     * @param context 上下文对象
     * @param datas   要显示的广告数据
     */
    public GalleryPagerAdapter(Context context, List<Advert> datas) {
        this.mDatas = datas;
        this.mContext = context;
        if (datas.size() == 1) {
            mPagerWidth = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            mPagerWidth = context.getResources().getDisplayMetrics().widthPixels * PAGE_WIDTH / SCREEN_WIDTH_MAX;
        }
    }

    @Override
    public int getCount() {
        if (mDatas == null) {
            return 0;
        }
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = createView(mDatas.get(position).getImgUrl(), mDatas.get(position).getAction());
        container.addView(view);
        return view;
    }

    /**
     * 创建一个View
     *
     * @param url   图片的url
     * @param title 图片的标题
     * @return 创建的view
     */
    public View createView(String url, String title) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pager_ads, null);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.rl);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        ViewGroup.LayoutParams lp = iv.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(mPagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = mPagerWidth;
            lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        }
        MyLog.i(TAG, url);
        Glide.with(mContext).load(url).placeholder(R.drawable.default_big).fallback(R.drawable.default_big).into(iv);
        iv.setLayoutParams(lp);
        tv.setText(title);
        return view;
    }


}
