package com.suwen.suwenandroid2016v1.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuhongbin on 16/4/19.
 */
public class ListData {
    @SerializedName("data")
    private List<Data> datas = new ArrayList<>();

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }
}
