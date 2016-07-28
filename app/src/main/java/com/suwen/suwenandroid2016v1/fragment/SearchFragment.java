package com.suwen.suwenandroid2016v1.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.adapter.SearchHistoryAdapter;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    private Context mContext;
    /**搜索历史记录ListView*/
    private ListView mSearchHistoryListView;
    private List<String> mHistoryDatas;
    private SearchHistoryAdapter mHistoryAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SearchFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }


    private void initView(View view) {
        mSearchHistoryListView = (ListView) view.findViewById(R.id.lv_search_history);
        mHistoryDatas = new ArrayList<>();
        mHistoryAdapter = new SearchHistoryAdapter(mContext,R.layout.item_search_history,mHistoryDatas);
        mSearchHistoryListView.setAdapter(mHistoryAdapter);
    }
    private void initData() {
        mHistoryDatas.add("夏天避暑");
        mHistoryDatas.add("头发枯黄");
        mHistoryDatas.add("眼睛干涩");
        mHistoryDatas.add("大姨妈不调");
        mHistoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
