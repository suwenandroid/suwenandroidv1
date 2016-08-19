package com.suwen.suwenandroid2016v1.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.activity.AppSettingActivity;
import com.suwen.suwenandroid2016v1.activity.FeedbackActivity;
import com.suwen.suwenandroid2016v1.activity.UserInfoActivity;
import com.suwen.suwenandroid2016v1.adapter.MineAdapter;

import java.util.ArrayList;
import java.util.List;


public class MineFragment extends BaseFragment implements View.OnClickListener {
    private Context mContext;
    private ListView mListView;
    private MineAdapter mineAdapter;
    private List<String> mList;

    //头像按钮
    private ImageButton imgAvater;
    //设置的按钮
    private TextView tvSetting;
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

    public MineFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
    }

    @Override
    protected int getContentView() {

        return R.layout.fragment_mine;
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
        setListener();
    }

    private void setListener() {
        imgAvater.setOnClickListener(this);
        tvSetting.setOnClickListener(this);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(mContext,AppSettingActivity.class));
                        break;
                    case 1:

                        break;
                    case 2:
                        startActivity(new Intent(mContext, FeedbackActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void loadData() {
        mList.add("App设置");
        mList.add("分享给好友");
        mList.add("意见反馈");
        mList.add("关于");
        mineAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.lv_min);
        mList = new ArrayList<>();
        mineAdapter = new MineAdapter(mContext, R.layout.item_mine, mList);
        mListView.setAdapter(mineAdapter);
        imgAvater = (ImageButton) view.findViewById(R.id.imgbtn_mine_avater);
        tvSetting = (TextView) view.findViewById(R.id.tv_setting);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgbtn_mine_avater:
                startActivity(new Intent(getActivity(), UserInfoActivity.class));
                break;
            case R.id.tv_setting:
                startActivity(new Intent(getActivity(), AppSettingActivity.class));
                break;
            default:
                break;
        }
    }
}
