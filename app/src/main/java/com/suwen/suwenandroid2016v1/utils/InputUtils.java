package com.suwen.suwenandroid2016v1.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by chan on 2016/8/17.
 */
public class InputUtils {

    public static void showInput(Context context, View view) {
        ((InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .showSoftInput(view, 0);

    }

    public static void hintInput(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(new View(context).getApplicationWindowToken(), 0);
        }
    }
}