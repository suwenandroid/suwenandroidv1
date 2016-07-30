package com.suwen.suwenandroid2016v1.utils.popup;

import android.content.Context;

import com.suwen.suwenandroid2016v1.R;


/**
 * 弹框工具类
 *
 * @author stephen.fan
 * @version 3.1.0
 * @since 2016-07-19 17:15
 */
public class PopupUtils {
    private static final String TAG = PopupUtils.class.getSimpleName();


    /******************************************        无标题 + 内容 + 一个按钮       ******************************************/

    /**
     * 可设置：内容、点击监听
     *
     * @param context                    Context
     * @param contentId                  内容文本ID
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showNoTitleDialog(context, contentId, R.string.ok, neutralButtonClickListener, true);
    }

    /**
     * 可设置：内容、按钮文本、点击监听
     *
     * @param context                    Context
     * @param contentId                  内容文本ID
     * @param neutralTextId              确定按钮文本ID
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         int neutralTextId,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showNoTitleDialog(context, contentId, neutralTextId, neutralButtonClickListener, true);
    }

    /**
     * 可设置：内容、按钮文本、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param contentId                    内容文本ID
     * @param neutralTextId                确定按钮文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         int neutralTextId,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable) {
        showNoTitleDialog(context, contentId, neutralTextId, neutralButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：内容、按钮文本、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param contentId                    内容文本ID
     * @param neutralTextId                确定按钮文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         int neutralTextId,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable,
                                         boolean cancel) {
        showNoTitleDialog(context, context.getString(contentId), neutralTextId, neutralButtonClickListener, canceledOnTouchOutsideEnable, cancel);
    }

    /**
     * 可设置：内容、点击监听
     *
     * @param context                    Context
     * @param content                    内容文本
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showNoTitleDialog(context, content, R.string.ok, neutralButtonClickListener, true, true);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param content                      内容文本
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable) {
        showNoTitleDialog(context, content, R.string.ok, neutralButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param content                      内容文本
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable,
                                         boolean cancel) {
        showNoTitleDialog(context, content, R.string.ok, neutralButtonClickListener, canceledOnTouchOutsideEnable, cancel);
    }

    /**
     * 可设置：内容、按钮文本、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param content                      内容文本
     * @param neutralTextId                确定按钮文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         int neutralTextId,
                                         BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable,
                                         boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == content) {
            return;
        }

        if (null == context.getString(neutralTextId)) {
            neutralTextId = R.string.ok;
        }

        CommonDialog dialog = new CommonDialog(context, neutralTextId, neutralButtonClickListener);
        dialog.setHeaderVisible(false);
        dialog.setContentText(content);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /******************************************        无标题 + 内容 + 两个按钮       ******************************************/


    /**
     * 可设置：内容、点击回调
     *
     * @param context                     Context
     * @param contentId                   内容文本ID
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                         BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showNoTitleDialog(context, contentId, R.string.ok, R.string.cancel, positiveButtonClickListener,
                negativeButtonClickListener, true, true);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param contentId                    内容文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                         BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable) {
        showNoTitleDialog(context, contentId, R.string.ok, R.string.cancel, positiveButtonClickListener,
                negativeButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 无标题、两个按钮
     * 可设置：内容、按钮文本、点击是否消失
     *
     * @param context                      Context
     * @param contentId                    内容文本ID
     * @param positiveTextId               确定按钮文本ID
     * @param negativeTextId               取消按钮文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         int contentId,
                                         int positiveTextId,
                                         int negativeTextId,
                                         BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                         BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable,
                                         boolean cancel) {
        showNoTitleDialog(context, context.getString(contentId), positiveTextId, negativeTextId,
                positiveButtonClickListener, negativeButtonClickListener, canceledOnTouchOutsideEnable, cancel);
    }

    /**
     * 可设置：内容、点击监听
     *
     * @param context                     Context
     * @param content                     内容文本
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                         BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showNoTitleDialog(context, content, R.string.ok, R.string.cancel, positiveButtonClickListener,
                negativeButtonClickListener, true, true);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param content                      内容文本
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                         BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable) {
        showNoTitleDialog(context, content, R.string.ok, R.string.cancel, positiveButtonClickListener,
                negativeButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 无标题、两个按钮
     * 可设置：内容、按钮文本、点击是否消失
     *
     * @param context                      Context
     * @param content                      内容文本
     * @param positiveTextId               确定按钮文本ID
     * @param negativeTextId               取消按钮文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showNoTitleDialog(Context context,
                                         CharSequence content,
                                         int positiveTextId,
                                         int negativeTextId,
                                         BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                         BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                         boolean canceledOnTouchOutsideEnable,
                                         boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == content) {
            return;
        }

        if (null == context.getString(positiveTextId)) {
            positiveTextId = R.string.ok;
        }

        if (null == context.getString(negativeTextId)) {
            negativeTextId = R.string.cancel;
        }

        CommonDialog dialog = new CommonDialog(context, positiveTextId, positiveButtonClickListener, negativeTextId, negativeButtonClickListener);
        dialog.setHeaderVisible(false);
        dialog.setContentText(content);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }


    /********************************************     标题 + 内容 + 一个按钮    ***********************************************/

    /**
     * 可设置：内容、点击监听
     *
     * @param context                    Context
     * @param content                    文本内容
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showDialog(Context context,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showDialog(context, context.getString(R.string.dialog_title), content, neutralButtonClickListener);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param content                      文本内容
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, context.getString(R.string.dialog_title), content, neutralButtonClickListener, canceledOnTouchOutsideEnable);
    }

    /**
     * 可设置：内容、点击监听
     *
     * @param context                    Context
     * @param contentId                  内容文本ID
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showDialog(Context context,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showDialog(context, R.string.dialog_title, contentId, neutralButtonClickListener);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param contentId                    内容文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, R.string.dialog_title, contentId, neutralButtonClickListener, canceledOnTouchOutsideEnable);
    }

    /**
     * 可设置：标题、内容、点击监听
     *
     * @param context                    Context
     * @param title                      标题文本
     * @param content                    内容文本
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showDialog(context, title, content, neutralButtonClickListener, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, title, content, neutralButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable,
                                  boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == content) {
            return;
        }

        CommonDialog dialog = new CommonDialog(context, neutralButtonClickListener);
        dialog.setTitle(title);
        dialog.setContentText(content);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 可设置：标题、内容、点击监听
     *
     * @param context                    Context
     * @param titleId                    标题文本ID
     * @param contentId                  内容文本ID
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showDialog(context, titleId, contentId, neutralButtonClickListener, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param titleId                      标题文本ID
     * @param contentId                    内容文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, titleId, contentId, neutralButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param titleId                      标题文本ID
     * @param contentId                    内容文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable,
                                  boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == context.getString(contentId)) {
            return;
        }

        CommonDialog dialog = new CommonDialog(context, neutralButtonClickListener);
        dialog.setTitle(titleId);
        dialog.setContentText(contentId);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 可设置：标题、内容、按钮文本、点击回调
     *
     * @param context                    Context
     * @param titleId                    标题文本ID
     * @param contentId                  内容文本ID
     * @param neutralTextId              确定按钮文本ID
     * @param neutralButtonClickListener 确认按钮监听接口
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  int neutralTextId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener) {
        showDialog(context, titleId, contentId, neutralTextId, neutralButtonClickListener, true);
    }

    /**
     * 可设置：标题、内容、按钮文本、点击回调、点击是否消失
     *
     * @param context                      Context
     * @param titleId                      标题文本ID
     * @param contentId                    内容文本ID
     * @param neutralTextId                确定按钮文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  int neutralTextId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, titleId, contentId, neutralTextId, neutralButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、按钮文本、点击回调、点击是否消失
     *
     * @param context                      Context
     * @param titleId                      标题文本ID
     * @param contentId                    内容文本ID
     * @param neutralTextId                确定按钮文本ID
     * @param neutralButtonClickListener   确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  int neutralTextId,
                                  BaseDialog.OnButtonClickListener neutralButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable,
                                  boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == context.getString(contentId)) {
            return;
        }

        if (null == context.getString(neutralTextId)) {
            neutralTextId = R.string.ok;
        }

        CommonDialog dialog = new CommonDialog(context, neutralTextId, neutralButtonClickListener);
        dialog.setTitle(titleId);
        dialog.setContentText(contentId);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /******************************************        标题 + 内容 + 两个按钮        ********************************************/

    /**
     * 可设置：内容、点击监听
     *
     * @param context                     Context
     * @param contentId                   内容文本ID
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showDialog(Context context,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showDialog(context, R.string.dialog_title, contentId, positiveButtonClickListener, negativeButtonClickListener, true, true);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param contentId                    内容文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, R.string.dialog_title, contentId, positiveButtonClickListener, negativeButtonClickListener,
                canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、点击监听
     *
     * @param context                     Context
     * @param titleId                     标题文本ID
     * @param contentId                   内容文本ID
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showDialog(context, titleId, contentId, positiveButtonClickListener, negativeButtonClickListener, true, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param titleId                      标题文本ID
     * @param contentId                    内容文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, titleId, contentId, positiveButtonClickListener, negativeButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param titleId                      标题文本ID
     * @param contentId                    内容文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialog(Context context,
                                  int titleId,
                                  int contentId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable,
                                  boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == context.getString(contentId)) {
            return;
        }

        CommonDialog dialog = new CommonDialog(context, positiveButtonClickListener, negativeButtonClickListener);
        dialog.setTitle(titleId);
        dialog.setContentText(contentId);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 可设置：标题、内容、点击监听
     *
     * @param context                     Context
     * @param title                       标题文本
     * @param content                     内容文本
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showDialog(context, title, content, positiveButtonClickListener, negativeButtonClickListener, true, true);
    }

    /**
     * 可设置：内容、点击监听
     *
     * @param context                     Context
     * @param content                     内容文本
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showDialog(Context context,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showDialog(context, context.getString(R.string.dialog_title), content,
                positiveButtonClickListener, negativeButtonClickListener, true, true);
    }

    /**
     * 可设置：内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param content                      内容文本
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, context.getString(R.string.dialog_title), content,
                positiveButtonClickListener, negativeButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, title, content, positiveButtonClickListener, negativeButtonClickListener, canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置：标题、内容、点击监听、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable,
                                  boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == content) {
            return;
        }

        CommonDialog dialog = new CommonDialog(context, positiveButtonClickListener, negativeButtonClickListener);
        dialog.setTitle(title);
        dialog.setContentText(content);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 可设置：内容、按钮文本、回调
     *
     * @param context                     Context
     * @param content                     内容文本
     * @param positiveTextId              确定按钮文本ID
     * @param negativeTextId              取消按钮文本ID
     * @param positiveButtonClickListener 确认按钮监听接口
     * @param negativeButtonClickListener 取消按钮监听接口
     */
    public static void showDialog(Context context,
                                  CharSequence content,
                                  int positiveTextId,
                                  int negativeTextId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener) {
        showDialog(context, context.getString(R.string.dialog_title), content,
                positiveTextId, negativeTextId, positiveButtonClickListener, negativeButtonClickListener, true);
    }

    /**
     * 可设置： 标题、内容、按钮文本、回调、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param positiveTextId               确定按钮文本ID
     * @param negativeTextId               取消按钮文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  int positiveTextId,
                                  int negativeTextId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable) {
        showDialog(context, title, content, positiveTextId, negativeTextId,
                positiveButtonClickListener, negativeButtonClickListener,
                canceledOnTouchOutsideEnable, true);
    }

    /**
     * 可设置： 标题、内容、按钮文本、回调、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param positiveTextId               确定按钮文本ID
     * @param negativeTextId               取消按钮文本ID
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param negativeButtonClickListener  取消按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialog(Context context,
                                  CharSequence title,
                                  CharSequence content,
                                  int positiveTextId,
                                  int negativeTextId,
                                  BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                  BaseDialog.OnButtonClickListener negativeButtonClickListener,
                                  boolean canceledOnTouchOutsideEnable,
                                  boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == content) {
            return;
        }

        if (null == context.getString(positiveTextId)) {
            positiveTextId = R.string.ok;
        }

        if (null == context.getString(negativeTextId)) {
            negativeTextId = R.string.cancel;
        }

        CommonDialog dialog = new CommonDialog(context, positiveTextId, positiveButtonClickListener, negativeTextId, negativeButtonClickListener);
        dialog.setTitle(title);
        dialog.setContentText(content);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }

    /**
     * 带有icon的一个按钮
     * 可设置： 标题、内容、icon、回调、点击是否消失
     *
     * @param context                      Context
     * @param title                        标题文本
     * @param content                      内容文本
     * @param positiveButtonClickListener  确认按钮监听接口
     * @param canceledOnTouchOutsideEnable 是否允许触摸对话框以外的地方，关闭对话框
     * @param cancel                       点击back键时，是否关闭对话框
     */
    public static void showDialogWithIcon(Context context,
                                          CharSequence title,
                                          CharSequence content,
                                          int iconid,
                                          BaseDialog.OnButtonClickListener positiveButtonClickListener,
                                          boolean canceledOnTouchOutsideEnable,
                                          boolean cancel) {
        if (null == context) {
            return;
        }

        if (null == content) {
            return;
        }


        CommonDialog dialog = new CommonDialog(context, positiveButtonClickListener);
        dialog.setTitleIcon(iconid);
        dialog.setTitle(title);
        dialog.setContentText(content);
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutsideEnable);
        dialog.setCancelable(cancel);
        dialog.show();
    }


}
