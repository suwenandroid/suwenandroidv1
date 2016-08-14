package com.suwen.suwenandroid2016v1.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.activity.DetailActivity;
import com.suwen.suwenandroid2016v1.adapter.AbsAdapter;
import com.suwen.suwenandroid2016v1.adapter.DataAdapter;
import com.suwen.suwenandroid2016v1.adapter.GalleryPagerAdapter;
import com.suwen.suwenandroid2016v1.adapter.InfinitePagerAdapter;
import com.suwen.suwenandroid2016v1.anim.ZoomOutPageTransformer;
import com.suwen.suwenandroid2016v1.beans.AdverList;
import com.suwen.suwenandroid2016v1.beans.SuwenList;
import com.suwen.suwenandroid2016v1.rest.RestClient;
import com.suwen.suwenandroid2016v1.utils.CommonUtils;
import com.suwen.suwenandroid2016v1.utils.RefreshUtil;
import com.suwen.suwenandroid2016v1.utils.SysUtil;
import com.suwen.suwenandroid2016v1.utils.popup.BaseDialog;
import com.suwen.suwenandroid2016v1.utils.popup.PopupUtils;
import com.suwen.suwenandroid2016v1.views.MyInfiniteViewPager;
import com.suwen.suwenandroid2016v1.views.MyListView;
import com.suwen.suwenandroid2016v1.views.TabsScroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SuWenChildFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mAdContainer;
    private ImageView ivMore;
    private PullToRefreshScrollView mPullToRefreshScrollView;
    private Activity mActivity;
    private MyListView mListView;
    private List<SuwenList.DataBean.DataListBean> mDatas = new ArrayList<>();
    private AbsAdapter mSuwenAdapter;
    private MyInfiniteViewPager mInfiniteViewPager;
    private GalleryPagerAdapter mGalleryPagerAdapter;
    private List<AdverList.DataBean> mAderts = new ArrayList<>();
    private LinearLayout mLPoint = null;
    private TabsScroller mTabsScroller;
    private List<String> mStringList = new ArrayList<>();
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
    private static final int PAGE_NUM = 10;
    private int mCurrentPage = 0;
    private String catId = "1";
    private int page = 1;

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

    private void setTabPagerIndicator() {
        mTabsScroller.setIndicatorMode(TabsScroller.IndicatorMode.MODE_NOWEIGHT_NOEXPAND_NOSAME);// 设置模式，一定要先设置模式
        mTabsScroller.setDividerColor(Color.parseColor("#00bbcf"));// 设置分割线的颜色
        mTabsScroller.setDividerPadding(CommonUtils.dip2px(mActivity, 10));
        mTabsScroller.setIndicatorColor(Color.parseColor("#43A44b"));// 设置底部导航线的颜色
        mTabsScroller.setTextColorSelected(Color.parseColor("#ffffff"));// 设置tab标题选中的颜色
        mTabsScroller.setTextColor(Color.parseColor("#666666"));// 设置tab标题未被选中的颜色
        mTabsScroller.setTextSize(16);// 设置字体大小
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mStringList.add("测试1");
        mStringList.add("测试2");
     /*   mStringList.add("测试3333");
        mStringList.add("测试444");
        mStringList.add("测试555");*/
        mStringList.add("测试666");
        mStringList.add("测试777");
        mStringList.add("测试8");
        mStringList.add("测试3");
        if (mStringList.size() > 5) {
            ivMore.setVisibility(View.VISIBLE);
        }
        RestClient.getApiService().getAdvertList("5", new Callback<AdverList>() {
            @Override
            public void success(AdverList adverList, Response response) {
                mAderts.clear();
                mAderts.addAll(adverList.getData());
            }

            @Override
            public void failure(RetrofitError error) {
                //mInfiniteViewPager.setVisibility(View.GONE);
            }
        });
        mTabsScroller.setIndicatorMode(TabsScroller.IndicatorMode.MODE_NOWEIGHT_EXPAND_SAME);
        mTabsScroller.setStrings(mStringList);
        /**
         * Test接口
         */
        //使用RESTFUL风格。一个网络请求的步骤如下：
        //1:封装请求数据的实体对象，放在rest.model下
        //2:在ApiServices中添加请求接口
        //3:通过RestClient.getApiService()调用接口方法，然后传递参数，数据就从服务器自动下载，然后转化为了实体对象，回调到了UI线程
        RestClient.getApiService().getSuwenList(catId, page + "", PAGE_NUM + "", new Callback<SuwenList>() {
            @Override
            public void success(SuwenList suwenList, Response response) {
                mSuwenAdapter.addAll(suwenList.getData().getDataList());
                mGalleryPagerAdapter.notifyDataSetChanged();
                if (mLPoint != null && mLPoint.getChildCount() > 0) {
                    mLPoint.removeAllViews();
                }

                if (mAderts.size() > 0) {
                    mInfiniteViewPager.setVisibility(View.VISIBLE);
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
                        mPagerWidth = (getResources().getDisplayMetrics().widthPixels * 4 / POINT_MARGIN_LEFT);
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
                } else {
                    mInfiniteViewPager.setVisibility(View.GONE);

                }
            }

            @Override
            public void failure(RetrofitError error) {
                mInfiniteViewPager.setVisibility(View.GONE);
            }
        });


    }


    /**
     * 初始化UI
     *
     * @param mRootView
     */
    private void initView(View mRootView) {
        if (mPullToRefreshScrollView == null) {
            mPullToRefreshScrollView = (PullToRefreshScrollView) mRootView.findViewById(R.id.suwen_pull_scrollview);
        }
        new RefreshUtil().initScollView(mActivity, PullToRefreshBase.Mode.BOTH, mPullToRefreshScrollView);
        if (mListView == null) {
            mListView = (MyListView) mRootView.findViewById(R.id.suwen_listview);
        }
        mListView.setFocusable(false);
        mSuwenAdapter = new DataAdapter(mActivity, R.layout.item_data, mDatas);
        mListView.setAdapter(mSuwenAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", mDatas.get(position));
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
        if (mInfiniteViewPager == null) {
            mInfiniteViewPager = (MyInfiniteViewPager) mRootView.findViewById(R.id.ad_pager);
        }
        if (mLPoint == null) {
            mLPoint = (LinearLayout) mRootView.findViewById(R.id.ll_point);
        }
        mAdContainer = (RelativeLayout) mRootView.findViewById(R.id.gallery_viewpager_layout);
        mGalleryPagerAdapter = new GalleryPagerAdapter(mActivity, mAderts);
        mTabsScroller = (TabsScroller) mRootView.findViewById(R.id.tabscroller);
        ivMore = (ImageView) mRootView.findViewById(R.id.suwen_iv_more);
        ivMore.setOnClickListener(this);
        setTabPagerIndicator();
        mTabsScroller.setCallBack(new TabsScroller.CallBack() {
            @Override
            public void callBack(int position) {
                PopupUtils.showDialog(mActivity, "我是标题", "被点击的是-----" + position, new BaseDialog.OnButtonClickListener() {
                    @Override
                    public void onClick(Object result) {

                    }
                });
            }
        });
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.suwen_iv_more:
                mTabsScroller.scrollToCenter();
                break;
        }
    }

}
