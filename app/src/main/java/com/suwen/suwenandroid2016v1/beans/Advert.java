package com.suwen.suwenandroid2016v1.beans;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.1.1
 * @since 2016-07-28 23:25
 */
public class Advert {
    private String imgUrl;
    private String action;
    private String productNo;
    private String hrefUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
