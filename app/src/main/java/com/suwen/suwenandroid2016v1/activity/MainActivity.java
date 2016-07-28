package com.suwen.suwenandroid2016v1.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.adapter.DataAdapter;
import com.suwen.suwenandroid2016v1.fragment.MineFragment;
import com.suwen.suwenandroid2016v1.fragment.SearchFragment;
import com.suwen.suwenandroid2016v1.fragment.SuWenFragment;
import com.suwen.suwenandroid2016v1.rest.RestClient;
import com.suwen.suwenandroid2016v1.rest.model.Data;
import com.suwen.suwenandroid2016v1.rest.model.ListData;
import com.suwen.suwenandroid2016v1.utils.BottomTabUtils;
import com.suwen.suwenandroid2016v1.utils.RefreshUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity {
    private PullToRefreshListView listView;
    private List<Data> datas = new ArrayList<>();
    private DataAdapter adapter;
    /**
     * 底部Tab RadioGroup
     */
    private RadioGroup mBottomTabGroup;
    private List<Fragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoading("正在加载数据。。。");
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setBottomTab(); //处理底部的Tab
        listView = (PullToRefreshListView) findViewById(R.id.listview);
        adapter = new DataAdapter(getApplicationContext(), R.layout.item_data, datas);
        listView.setAdapter(adapter);
        //使用工具类，设置pulltoRefreshListvew的刷新模式
        new RefreshUtil().initListView(getApplicationContext(), PullToRefreshBase.Mode.BOTH, listView);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshData();
                    }
                }, 500);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                listView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                    }
                }, 500);
            }
        });


    }

    //设置main底部的Tab
    private void setBottomTab() {
        mBottomTabGroup = (RadioGroup) this.findViewById(R.id.group_main_tab);
        mFragments = new ArrayList<>();
        mFragments.add(SuWenFragment.newInstance("",""));
        mFragments.add(SearchFragment.newInstance("",""));
        mFragments.add(MineFragment.newInstance("",""));
        new BottomTabUtils(mBottomTabGroup, mFragments, getSupportFragmentManager(), R.id.mian_container);
    }

    @Override
    protected void initData() {
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
                adapter.addAll(listData.getDatas());
                dismissLoading();
            }

            @Override
            public void failure(RetrofitError error) {
                dismissLoading();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void refreshData() {
        adapter.clear();
        initData();
        listView.onRefreshComplete();
    }

    public void loadMore() {
        initData();
        listView.onRefreshComplete();
    }
}
