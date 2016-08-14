package com.suwen.suwenandroid2016v1.rest.services;


import com.suwen.suwenandroid2016v1.beans.AdverList;
import com.suwen.suwenandroid2016v1.beans.SuwenList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by niuhongbin on 16/4/18.
 */
public interface ApiService {

    @GET("/api/info")
    void getSuwenList(@Query("catId") String catId, @Query("page") String page, @Query("PageSize") String PageSize, Callback<SuwenList> callback);

    @GET("/api/index/sliderPhoto")
    void getAdvertList(@Query("cnt") String cnt, Callback<AdverList> callback);
}
