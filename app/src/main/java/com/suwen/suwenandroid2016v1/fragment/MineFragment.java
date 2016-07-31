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
import com.suwen.suwenandroid2016v1.adapter.MineAdapter;

import java.util.ArrayList;
import java.util.List;


public class MineFragment extends Fragment {
    private Context mContext;
    private ListView mListView;
    private MineAdapter mineAdapter;
    private List<String> mList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MineFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        loadData();
    }

    private void loadData() {
        mList.add("我的钱包");
        mList.add("分享给好友");
        mList.add("联系我们");
        mList.add("收货地址");
        mineAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.lv_min);
        mList = new ArrayList<>();
        mineAdapter  = new MineAdapter(mContext,R.layout.item_mine,mList);
        mListView.setAdapter(mineAdapter);
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
