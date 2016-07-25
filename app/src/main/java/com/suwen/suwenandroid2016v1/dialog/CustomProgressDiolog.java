package com.suwen.suwenandroid2016v1.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;
import com.suwen.suwenandroid2016v1.views.LoadingAnimView;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.0
 * @since 2016-07-25 23:12
 */
public class CustomProgressDiolog extends AlertDialog {

    @SuppressWarnings("unused")
    private LoadingAnimView mLoadingAnim;
    private TextView mMessageView;
    private String mMessage;

    public CustomProgressDiolog(Context context, int theme) {
        super(context, theme);
        // TODO Auto-generated constructor stub
    }

    public CustomProgressDiolog(Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.custom_progress_dialog);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        mLoadingAnim = (LoadingAnimView) findViewById(R.id.tipLoading);
        mMessageView = (TextView) findViewById(R.id.tv_message);
        mMessageView.setText(mMessage);
    }


    public static CustomProgressDiolog show(Context context, String message) {
        CustomProgressDiolog dialog = new CustomProgressDiolog(context, R.style.CustomDialogTheme);
        dialog.setCancelable(false);
        dialog.setContentMessage(message);
        dialog.show();
        return dialog;
    }

    private void setContentMessage(String message) {
        mMessage = message;
    }
}

