package com.suwen.suwenandroid2016v1.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.utils.InputUtils;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener {
    //返回按钮
    private ImageButton mImgBtnBack;
    //开启编辑模式的那个按钮
    private Button mBtnInfoEdit;
    //是否开启编辑模式
    private boolean isEdit;
    //昵称一个是EditText可以编辑的时候显示，
    // 一个是TextView在不可编辑的状态的时候显示
    private EditText mEditName;
    private TextView mTvName;
    //修改密码的按钮
    private Button mBtnChangePwd;


    @Override
    protected int getContentView() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView() {
        mImgBtnBack = (ImageButton) this.findViewById(R.id.imgbtn_back);
        mBtnInfoEdit = (Button) this.findViewById(R.id.btn_info_edit);
        mEditName = (EditText) this.findViewById(R.id.edit_name);
        mTvName = (TextView) this.findViewById(R.id.tv_name);
        mBtnChangePwd = (Button) this.findViewById(R.id.btn_setting_change_pwd);
    }

    @Override
    protected void initData() {
    setListener();
    }

    private void setListener() {
        mImgBtnBack.setOnClickListener(this);
        mBtnInfoEdit.setOnClickListener(this);
        mBtnChangePwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgbtn_back:
                this.finish();
                break;
            case R.id.btn_info_edit:
                dealEdit();
                break;
            case R.id.btn_setting_change_pwd:
                startActivity(new Intent(this,ChangePwdActivity.class));
                this.finish();
                break;
            default:
                break;
        }
    }

    /**
     * 处理编辑模式的逻辑
     */
    private void dealEdit() {
        isEdit = !isEdit;
        if(isEdit) {
            mBtnInfoEdit.setText("保存");
            mTvName.setVisibility(View.GONE);
            mEditName.setVisibility(View.VISIBLE);
            mEditName.requestFocus();
            InputUtils.showInput(this,mEditName);
            mEditName.setText(mTvName.getText().toString().trim());
            mEditName.setSelection(mTvName.getText().toString().trim().length());
        } else {
            mBtnInfoEdit.setText("编辑");
            InputUtils.hintInput(this);
            mEditName.setVisibility(View.GONE);
            mTvName.setVisibility(View.VISIBLE);
            mTvName.setText(mEditName.getText().toString().trim());
        }

    }
}
