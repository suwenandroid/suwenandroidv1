package com.suwen.suwenandroid2016v1.rest;

import com.google.gson.annotations.SerializedName;
import com.suwen.suwenandroid2016v1.BaseApp;
import com.suwen.suwenandroid2016v1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;


/**
 * Created by niuhongbin  on 4/19/2016.
 * Error Handler Rest Client
 */

// on error the server sends JSON
/*
 { "error": { "data": { "message":"A thing went wrong" } } }
*/

class ErrorResponse {
    @SerializedName("code")
    String code = "";
    @SerializedName("errors")
    List<Error> error = new ArrayList<Error>();

    public class Error {

        @SerializedName("code")
        String code = "";
        @SerializedName("msg")
        String msg = "";

    }
}

/**
 */
class CustomErrorHandler implements ErrorHandler {
    public CustomErrorHandler() {
    }

    @Override
    public Throwable handleError(RetrofitError cause) {
        String errorDescription = "";

        //根据不通的错误信息，设置不同的错误描述
        if (cause.getKind().equals(RetrofitError.Kind.NETWORK)) {
            errorDescription = BaseApp.getBaseAppInstance().getString(R.string.errors_no_network);
        } else if (cause.getResponse() == null) {
            errorDescription = BaseApp.getBaseAppInstance().getString(R.string.errors_timeout);
        } else if (cause.getResponse().getStatus() == 200) {
            errorDescription = "ok";
        } else {
            try {
                ErrorResponse errorResponse = (ErrorResponse) cause.getBodyAs(ErrorResponse.class);
                if (errorResponse == null || errorResponse.code == null || errorResponse.code.equals("")) {
                    errorDescription = BaseApp.getBaseAppInstance().getString(R.string.errors_no_network);
                } else {
                    errorDescription = errorResponse.error.get(0).msg;
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorDescription = BaseApp.getBaseAppInstance().getString(R.string.json_error);
            }

        }

        return new Exception(errorDescription);
    }
}
