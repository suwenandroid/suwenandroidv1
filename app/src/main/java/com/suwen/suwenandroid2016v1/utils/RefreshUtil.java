package com.suwen.suwenandroid2016v1.utils;

import android.content.Context;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.suwen.suwenandroid2016v1.R;


/**
 * Created by Mike on 2016/2/20.
 */
public class RefreshUtil {

    public void initListView(final Context context,
                             final PullToRefreshBase.Mode mode,
                             final PullToRefreshListView listView) {
        //  设置上拉下拉类型
        listView.setMode(mode);
        //  下拉加载更多时的提示文本设置
        listView.getLoadingLayoutProxy(true, false).setLastUpdatedLabel("");
        listView.getLoadingLayoutProxy(true, false).setPullLabel(context.getString(R.string.pull_to_refresh));
        listView.getLoadingLayoutProxy(true, false).setRefreshingLabel(context.getString(R.string.refreshing));
        listView.getLoadingLayoutProxy(true, false).setReleaseLabel(context.getString(R.string.release_to_refresh));
        // 上拉加载更多时的提示文本设置
        listView.getLoadingLayoutProxy(false, true).setLastUpdatedLabel("");
        listView.getLoadingLayoutProxy(false, true).setPullLabel(context.getString(R.string.pull_to_load_more));
        listView.getLoadingLayoutProxy(false, true).setRefreshingLabel(context.getString(R.string.loading_datas));
        listView.getLoadingLayoutProxy(false, true).setReleaseLabel(context.getString(R.string.release_to_load));
    }

    public void initScollView(final Context context,
                              final PullToRefreshBase.Mode mode,
                              final PullToRefreshScrollView listView) {
        //  设置上拉下拉类型
        listView.setMode(mode);
        //  下拉加载更多时的提示文本设置
        listView.getLoadingLayoutProxy(true, false).setLastUpdatedLabel("");
        listView.getLoadingLayoutProxy(true, false).setPullLabel(context.getString(R.string.pull_to_refresh));
        listView.getLoadingLayoutProxy(true, false).setRefreshingLabel(context.getString(R.string.refreshing));
        listView.getLoadingLayoutProxy(true, false).setReleaseLabel(context.getString(R.string.release_to_refresh));
        // 上拉加载更多时的提示文本设置
        listView.getLoadingLayoutProxy(false, true).setLastUpdatedLabel("");
        listView.getLoadingLayoutProxy(false, true).setPullLabel(context.getString(R.string.pull_to_load_more));
        listView.getLoadingLayoutProxy(false, true).setRefreshingLabel(context.getString(R.string.loading_datas));
        listView.getLoadingLayoutProxy(false, true).setReleaseLabel(context.getString(R.string.release_to_load));
    }
}
