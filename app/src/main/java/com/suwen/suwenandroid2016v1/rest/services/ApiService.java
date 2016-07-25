package com.suwen.suwenandroid2016v1.rest.services;


import com.suwen.suwenandroid2016v1.rest.model.ListData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by niuhongbin on 16/4/18.
 */
public interface ApiService {
    @GET("/cate/getList")
    void getList(@Query("page") String page, Callback<ListData> callback);
}
