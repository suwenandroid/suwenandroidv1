package com.suwen.suwenandroid2016v1.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.adapter.AbsAdapter;
import com.suwen.suwenandroid2016v1.adapter.DataAdapter;
import com.suwen.suwenandroid2016v1.adapter.GalleryPagerAdapter;
import com.suwen.suwenandroid2016v1.adapter.InfinitePagerAdapter;
import com.suwen.suwenandroid2016v1.anim.ZoomOutPageTransformer;
import com.suwen.suwenandroid2016v1.beans.Advert;
import com.suwen.suwenandroid2016v1.rest.RestClient;
import com.suwen.suwenandroid2016v1.rest.model.Data;
import com.suwen.suwenandroid2016v1.rest.model.ListData;
import com.suwen.suwenandroid2016v1.utils.SysUtil;
import com.suwen.suwenandroid2016v1.utils.ToastUtils;
import com.suwen.suwenandroid2016v1.views.MyInfiniteViewPager;
import com.suwen.suwenandroid2016v1.views.MyListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SuWenChildFragment extends BaseFragment {

    private RelativeLayout mAdContainer;
    private Activity mActivity;
    private MyListView mListView;
    private List<Data> mDatas = new ArrayList<>();
    private AbsAdapter mSuwenAdapter;
    private MyInfiniteViewPager mInfiniteViewPager;
    private GalleryPagerAdapter mGalleryPagerAdapter;
    private List<Advert> mAderts = new ArrayList<>();
    private LinearLayout mLPoint = null;
    private int mPagerWidth = 0;
    private static final int LIMIT_PAGES = 4;
    private static final int MARGIN_10 = 10;
    private static final int SCROLL_PAGE = 1;
    private static final int PAGE_DELAY = 4000;
    private static final int PAGE_COUNT = 1000;
    private static final int ONE_THOUND = 100;
    private static final int POINT_WIDTH_HEIGHT = 6;
    private static final int POINT_MARGIN_LEFT = 5;
    private static final int POINT_MARGIN_BOTTOM = 20;
    private int mCurrentPage = 0;
    private Timer mTimer = null;
    private TimerTask mTask = null;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SCROLL_PAGE:
                    mCurrentPage = mCurrentPage + 1;
                    mInfiniteViewPager.setCurrentItem(mCurrentPage, true);
                    break;
                default:
                    break;
            }
        }
    };

    public static SuWenChildFragment getInstance() {
        return new SuWenChildFragment();
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_suwen_child;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = super.onCreateView(inflater, container, savedInstanceState);
        initView(mRootView);
        initData();
        return mRootView;
    }

    /**
     * 初始化数据
     */
    private void initData() {

        /**
         * Test接口
         */
        //使用RESTFUL风格。一个网络请求的步骤如下：
        //1:封装请求数据的实体对象，放在rest.model下
        //2:在ApiServices中添加请求接口
        //3:通过RestClient.getApiService()调用接口方法，然后传递参数，数据就从服务器自动下载，然后转化为了实体对象，回调到了UI线程
        RestClient.getApiService().getList("1", new Callback<ListData>() {
            @Override
            public void success(ListData listData, Response response) {
                mSuwenAdapter.addAll(listData.getDatas());
            }

            @Override
            public void failure(RetrofitError error) {
                ToastUtils.show(error.getMessage());
            }
        });
        if (mAderts != null) {
            mAderts.clear();
        }
        Advert advert = new Advert();
        advert.setAction("Test1");
        advert.setImgUrl("http://img0.imgtn.bdimg.com/it/u=3691468346,2920721396&fm=21&gp=0.jpg");
        mAderts.add(advert);
        Advert advert1 = new Advert();
        advert1.setAction("Test2");
        advert1.setImgUrl("http://img5q.duitang.com/uploads/item/201406/21/20140621135038_4Gt4t.jpeg");
        mAderts.add(advert1);
        Advert advert3 = new Advert();
        advert3.setAction("Test3");
        advert3.setImgUrl("http://cdnq.duitang.com/uploads/item/201504/09/20150409H3025_iXaZe.jpeg");
        mAderts.add(advert3);
        Advert advert4 = new Advert();
        advert4.setAction("Test4");
        advert4.setImgUrl("http://img4.duitang.com/uploads/item/201408/26/20140826204711_R2tJr.jpeg");
        mAderts.add(advert4);
        mGalleryPagerAdapter.notifyDataSetChanged();
        if (mLPoint != null && mLPoint.getChildCount() > 0) {
            mLPoint.removeAllViews();
        }
        if (mAderts.size() > 0) {
            for (int i = 0; i < mAderts.size(); i++) {
                //添加小圆点
                if (mAderts.size() > 1) {
                    ImageView imageView = new ImageView(mActivity);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SysUtil.dip2px(mActivity, POINT_WIDTH_HEIGHT),
                            SysUtil.dip2px(mActivity, POINT_WIDTH_HEIGHT));
                    params.setMargins(SysUtil.dip2px(mActivity, POINT_MARGIN_LEFT), SysUtil.dip2px(mActivity, MARGIN_10),
                            SysUtil.dip2px(mActivity, POINT_MARGIN_LEFT), SysUtil.dip2px(mActivity, POINT_MARGIN_BOTTOM));
                    imageView.setImageResource(R.drawable.drable_point);
                    imageView.setLayoutParams(params);
                    mLPoint.addView(imageView);
                    if (i == 0) {
                        imageView.setSelected(true);
                    }
                }
            }

            if (mAderts.size() <= 1) {
                mPagerWidth = getResources().getDisplayMetrics().widthPixels;
                mGalleryPagerAdapter = new GalleryPagerAdapter(mActivity, mAderts);
            } else {
                mPagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 4 / POINT_MARGIN_LEFT);
                if (mGalleryPagerAdapter == null) {
                    mGalleryPagerAdapter = new GalleryPagerAdapter(mActivity, mAderts);
                }
                mGalleryPagerAdapter.notifyDataSetChanged();
            }
            ViewGroup.LayoutParams lp = mInfiniteViewPager.getLayoutParams();
            if (lp == null) {
                lp = new ViewGroup.LayoutParams(mPagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
            } else {
                lp.width = mPagerWidth;
            }
            mInfiniteViewPager.setLayoutParams(lp); //设置页面宽度为屏幕的3/5
            mInfiniteViewPager.setOffscreenPageLimit(LIMIT_PAGES);  //设置ViewPager至多缓存4个Pager页面，防止多次加载
            mInfiniteViewPager.setPageMargin(SysUtil.dip2px(mActivity, MARGIN_10));  //设置Pager之间的间距
            mInfiniteViewPager.setAdapter(new InfinitePagerAdapter(mGalleryPagerAdapter));
            if (mAderts.size() > 1) {
                if (mTimer == null) {
                    mTimer = new Timer();
                    mTask = new TimerTask() {
                        @Override
                        public void run() {
                            mHandler.sendEmptyMessage(SCROLL_PAGE);
                        }
                    };
                    mTimer.schedule(mTask, PAGE_COUNT, PAGE_DELAY);
                }
            }
            mInfiniteViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
            mInfiniteViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset,
                                           int positionOffsetPixels) {
                    if (mAdContainer != null) {
                        mAdContainer.invalidate();  //更新超出区域页面，否则会出现页面缓存，导致页面效果不佳
                    }
                }

                @Override
                public void onPageSelected(int position) {
                    mCurrentPage = position - mAderts.size() * ONE_THOUND;
                    for (int i = 0; i < mLPoint.getChildCount(); i++) {
                        if (position % mAderts.size() == i) {
                            mLPoint.getChildAt(i).setSelected(true);
                        } else {
                            mLPoint.getChildAt(i).setSelected(false);
                        }
                    }

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }


    /**
     * 初始化UI
     *
     * @param mRootView
     */
    private void initView(View mRootView) {
        if (mListView == null) {
            mListView = (MyListView) mRootView.findViewById(R.id.suwen_listview);
        }
        mListView.setFocusable(false);
        mSuwenAdapter = new DataAdapter(mActivity, R.layout.item_data, mDatas);
        mListView.setAdapter(mSuwenAdapter);

        if (mInfiniteViewPager == null) {
            mInfiniteViewPager = (MyInfiniteViewPager) mRootView.findViewById(R.id.ad_pager);
        }
        if (mLPoint == null) {
            mLPoint = (LinearLayout) mRootView.findViewById(R.id.ll_point);
        }
        mAdContainer = (RelativeLayout) mRootView.findViewById(R.id.gallery_viewpager_layout);
        mGalleryPagerAdapter = new GalleryPagerAdapter(mActivity, mAderts);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTask != null) {
            mTask.cancel();
            mTask = null;
        }
        //移除handler的消息，可以避免内存泄漏
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }
}
