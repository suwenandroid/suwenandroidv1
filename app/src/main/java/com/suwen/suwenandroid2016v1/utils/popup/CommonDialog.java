package com.suwen.suwenandroid2016v1.utils.popup;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;


/**
 * 常用dialog
 *
 * @author hongbin.niu
 * @version 3.1.0
 * @since 2016-07-20 10:58
 */
public class CommonDialog extends BaseDialog {

    private TextView mContentText;

    /**
     * 一个按钮
     *
     * @param context         Context
     * @param neutralListener OnButtonClickListener
     */
    public CommonDialog(Context context, OnButtonClickListener<CommonDialog> neutralListener) {
        this(context, R.string.ok, neutralListener);
    }

    /**
     * 一个按钮
     *
     * @param context         Context
     * @param neutralTextId   资源ID
     * @param neutralListener OnButtonClickListener
     */
    public CommonDialog(Context context, int neutralTextId, OnButtonClickListener<CommonDialog> neutralListener) {
        super(context);
        setButton(neutralTextId, neutralListener);
    }

    /**
     * 包括两个按钮
     *
     * @param context          Context
     * @param positiveListener OnButtonClickListener
     * @param negativeListener OnButtonClickListener
     */
    public CommonDialog(Context context, OnButtonClickListener<CommonDialog> positiveListener,
                        OnButtonClickListener<CommonDialog> negativeListener) {
        this(context, R.string.ok, positiveListener, R.string.cancel, negativeListener);
    }

    /**
     * 包括两个按钮
     *
     * @param context          Context
     * @param positiveTextId   资源ID
     * @param positiveListener OnButtonClickListener
     * @param negativeTextId   资源ID
     * @param negativeListener OnButtonClickListener
     */
    public CommonDialog(Context context, int positiveTextId, OnButtonClickListener<CommonDialog> positiveListener,
                        int negativeTextId, OnButtonClickListener<CommonDialog> negativeListener) {
        super(context);
        setButton(positiveTextId, positiveListener, negativeTextId, negativeListener);
    }

    @Override
    protected View onCreateBodyView(Context context) {
        View bodyView = View.inflate(context, R.layout.layout_common_dialog_body, null);
        mContentText = (TextView) bodyView.findViewById(R.id.tv_common_dialog_body);

        return bodyView;
    }

    /**
     * 设置内容文本
     *
     * @param resId 资源ID
     */
    public void setContentText(int resId) {
        mContentText.setText(getContext().getString(resId));
    }

    /**
     * 设置内容文本
     *
     * @param content CharSequence
     */
    public void setContentText(CharSequence content) {
        mContentText.setText(content);
    }

    @Override
    public void show() {
        setPositiveButtonHighLight(true);
        setNeutralButtonHighLight(true);
        super.show();
    }

    @Override
    protected CommonDialog onButtonClickEvent() {
        return this;
    }
}
