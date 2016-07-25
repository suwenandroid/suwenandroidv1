package com.suwen.suwenandroid2016v1.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by niuhongbin on 16/4/19.
 */
public class Data {

    /**
     * orderid : 1
     * cateid : 6
     * catename : 创意
     * alias : Idea
     * icon : http://cs.vmoiver.com/Uploads/Series/2016-04-12/570c9f3d1bc2d.jpg
     */

    @SerializedName("orderid")
    private String orderid;
    @SerializedName("cateid")
    private String cateid;
    @SerializedName("catename")
    private String catename;
    @SerializedName("alias")
    private String alias;
    @SerializedName("icon")
    private String icon;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
