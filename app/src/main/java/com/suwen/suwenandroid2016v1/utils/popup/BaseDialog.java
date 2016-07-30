package com.suwen.suwenandroid2016v1.utils.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suwen.suwenandroid2016v1.R;

/**
 * 标准对话框
 *
 * @author stephen.fan
 * @version 3.1.0
 * @since 2016-07-19 17:18
 */
public abstract class BaseDialog extends Dialog {
    private View mRootView;
    private ViewGroup mHeader;
    private ViewGroup mBody;
    private ViewGroup mFooter;
    private TextView mTitleView;
    private Button mPositiveButton;
    private Button mNeutralButton;
    private Button mNegativeButton;

    private OnButtonClickListener mOnPositiveButtonClickListener;
    private OnButtonClickListener mOnNegativeButtonClickListener;
    private OnButtonClickListener mOnNeutralButtonClickListener;

    private boolean mDismissOnButtonClick = true;

    /**
     * constructor
     *
     * @param context Context
     */
    public BaseDialog(Context context) {
        this(context, R.style.Theme_Dialog);
    }

    /**
     * constructor
     *
     * @param context Context
     * @param theme   int
     */
    public BaseDialog(Context context, int theme) {
        super(context, theme);

        setCancelable(true);
        setCanceledOnTouchOutside(true);

        mRootView = View.inflate(getContext(), R.layout.layout_dialog_main, null);
        mHeader = (ViewGroup) mRootView.findViewById(R.id.dialog_header);
        mBody = (ViewGroup) mRootView.findViewById(R.id.dialog_body);
        mFooter = (ViewGroup) mRootView.findViewById(R.id.dialog_footer);
        mTitleView = (TextView) mHeader.findViewById(R.id.title);

        mNegativeButton = (Button) mFooter.findViewById(R.id.button_left);
        mNeutralButton = (Button) mFooter.findViewById(R.id.button_middle);
        mPositiveButton = (Button) mFooter.findViewById(R.id.button_right);

        bindButtonEvent();
        /** 添加Dialog的具体内容 */
        mBody.addView(onCreateBodyView(getContext()));

        setContentView(mRootView);
        setOnCancelListener(mOnCancelListener);
    }

    /**
     * 子类可通过此方法添加布局
     *
     * @param context Context
     * @return View
     */
    protected abstract View onCreateBodyView(Context context);


    protected abstract <T> T onButtonClickEvent();

    private void bindButtonEvent() {
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == mPositiveButton) {
                    if (mOnPositiveButtonClickListener != null) {
                        mOnPositiveButtonClickListener.onClick(onButtonClickEvent());
                    }
                } else if (v == mNegativeButton) {
                    if (mOnNegativeButtonClickListener != null) {
                        mOnNegativeButtonClickListener.onClick(onButtonClickEvent());
                    }
                } else if (v == mNeutralButton) {
                    if (mOnNeutralButtonClickListener != null) {
                        mOnNeutralButtonClickListener.onClick(onButtonClickEvent());
                    }
                }

                if (mDismissOnButtonClick || (v == mNegativeButton)) {
                    dismiss();
                }
            }
        };

        mPositiveButton.setOnClickListener(buttonClickListener);
        mNegativeButton.setOnClickListener(buttonClickListener);
        mNeutralButton.setOnClickListener(buttonClickListener);

        mPositiveButton.setText(R.string.ok);
        mNegativeButton.setText(R.string.cancel);
    }

    /**
     * 设置头是否可见
     *
     * @param visible 头是否可见
     */
    public void setHeaderVisible(boolean visible) {
        mHeader.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置底部是否可见
     *
     * @param visible 底部是否可见
     */
    public void setFooterVisible(boolean visible) {
        mFooter.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置背景资源
     *
     * @param resId 背景资源id
     */
    public void setBackgroundResource(int resId) {
        mRootView.setBackgroundResource(resId);
        mHeader.setBackgroundResource(resId);
        mFooter.setBackgroundResource(resId);
        mBody.setBackgroundResource(resId);
    }

    /**
     * 设置背景颜色
     *
     * @param color 背景颜色
     */
    public void setBackgroundColor(int color) {
        mRootView.setBackgroundColor(color);
        mHeader.setBackgroundColor(color);
        mFooter.setBackgroundColor(color);
        mBody.setBackgroundColor(color);
        mTitleView.setBackgroundColor(color);
    }

    /**
     * 设置背景颜色
     *
     * @param color 背景颜色
     */
    public void setViewBackgroundColor(int color) {
        mRootView.setBackgroundColor(color);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBody.setLayoutParams(params);
        mBody.setBackgroundColor(Color.parseColor("#000000"));
    }

    /**
     * 设置只有一个按钮的文本及事件回调
     *
     * @param textId   按钮文本
     * @param listener 按钮事件回调
     */
    public void setButton(int textId, OnButtonClickListener listener) {
        mPositiveButton.setVisibility(View.GONE);
        mNegativeButton.setVisibility(View.GONE);
        mNeutralButton.setVisibility(View.VISIBLE);
        mNeutralButton.setText(textId);
        mOnNeutralButtonClickListener = listener;
    }

    /**
     * 设置有两个按钮的按钮文本及事件回调
     *
     * @param positiveTextId   确定按钮文本
     * @param positiveListener 确定按钮事件回调
     * @param negativeTextId   取消按钮文本
     * @param negativeListener 取消按钮事件回调
     */
    public void setButton(int positiveTextId, OnButtonClickListener positiveListener,
                          int negativeTextId, OnButtonClickListener negativeListener) {
        mNeutralButton.setVisibility(View.GONE);
        mPositiveButton.setVisibility(View.VISIBLE);
        mNegativeButton.setVisibility(View.VISIBLE);

        mPositiveButton.setText(positiveTextId);
        mNegativeButton.setText(negativeTextId);

        mOnPositiveButtonClickListener = positiveListener;
        mOnNegativeButtonClickListener = negativeListener;
    }

    /**
     * 设置三个按钮的按钮文本及事件回调
     *
     * @param positiveTextId   确定按钮文本
     * @param positiveListener 确定按钮事件回调
     * @param negativeTextId   取消按钮文本
     * @param negativeListener 取消按钮事件回调
     * @param neutralTextId    中间按钮文本
     * @param neutralListener  中间按钮事件回调
     */
    public void setButton(int positiveTextId, OnButtonClickListener positiveListener,
                          int negativeTextId, OnButtonClickListener negativeListener,
                          int neutralTextId, OnButtonClickListener neutralListener) {
        setButton(positiveTextId, positiveListener, negativeTextId, negativeListener);

        mNeutralButton.setVisibility(View.VISIBLE);
        mNeutralButton.setText(neutralTextId);
        mOnNeutralButtonClickListener = neutralListener;
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getContext().getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        mTitleView.setText(title);
    }

    /**
     * 设置标题头图标
     *
     * @param titleIconId 标题头图标
     */
    public void setTitleIcon(int titleIconId) {
        mTitleView.setCompoundDrawablesWithIntrinsicBounds(titleIconId, 0, 0, 0);
    }

    /**
     * 对话框按钮点击监听接口
     *
     * @param <T> 监听接口返回的数据类型
     */
    public static interface OnButtonClickListener<T> {
        /**
         * 对话框按钮点击监听方法
         *
         * @param result 监听接口返回的数据类型
         */
        public void onClick(T result);
    }

    /**
     * 设置PositiveButton高亮
     *
     * @param isHighLight 是否高亮
     */
    public void setPositiveButtonHighLight(boolean isHighLight) {
        mPositiveButton.setTextColor(isHighLight
                ? getContext().getResources().getColor(R.color.dialog_text_title_highlight)
                : getContext().getResources().getColor(R.color.dialog_text_title));
        mPositiveButton.setBackgroundResource(isHighLight
                ? R.drawable.xml_background_dialog_button_highlight : R.drawable.xml_background_dialog_button);
    }

    /**
     * 设置NegativeButton高亮
     *
     * @param isHighLight 是否高亮
     */
    public void setNegativeButtonHighLight(boolean isHighLight) {
        mNegativeButton.setTextColor(isHighLight
                ? getContext().getResources().getColor(R.color.dialog_text_title_highlight)
                : getContext().getResources().getColor(R.color.dialog_text_title));
        mNegativeButton.setBackgroundResource(isHighLight
                ? R.drawable.xml_background_dialog_button_highlight : R.drawable.xml_background_dialog_button);
    }

    /**
     * 设置NeutralButton高亮
     *
     * @param isHighLight 是否高亮
     */
    public void setNeutralButtonHighLight(boolean isHighLight) {
        mNeutralButton.setTextColor(isHighLight
                ? getContext().getResources().getColor(R.color.dialog_text_title_highlight)
                : getContext().getResources().getColor(R.color.dialog_text_title));
        mNeutralButton.setBackgroundResource(isHighLight
                ? R.drawable.xml_background_dialog_button_highlight : R.drawable.xml_background_dialog_button);
    }

    /**
     * 设置点击的时候是否关闭对话框
     *
     * @param dismiss true,关闭,false,不关闭
     */
    public void setDismissOnButtonClick(boolean dismiss) {
        mDismissOnButtonClick = dismiss;
    }

    @Override
    public void show() {
        super.show();
    }

    private OnCancelListener mOnCancelListener = new OnCancelListener() {
        @Override
        public void onCancel(DialogInterface dialog) {
            if (mOnNegativeButtonClickListener != null) {
                mOnNegativeButtonClickListener.onClick(onButtonClickEvent());
            }
        }
    };

    @Override
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
