package com.suwen.suwenandroid2016v1.beans;

import java.util.List;

/**
 * Desp.
 *
 * @author hongbin.niu
 * @version 3.1.1
 * @since 2016-07-31 23:38
 */
public class AdverList {

    /**
     * code : 0
     * message : null
     * sampleTime : 1469979477
     */

    private ResultBean result;
    /**
     * title : Eum delectus repellendus sit aut.
     * content : Et veniam laboriosam nobis id consectetur qui id delectus. Vel modi distinctio blanditiis voluptatem nemo molestias nemo. Assumenda ipsum eius beatae earum. Voluptatem dolore et provident amet ullam.
     * infoId : 642
     * userId : 42
     * catId : 3
     * imgUrl : http://lorempixel.com/640/480/?34374
     * shareCount : 944
     * keepCount : 1027
     * likeCount : 1353
     * scannedCount : 4997
     * createdAt : 2016-07-31 04:05:30
     * updatedAt : 2016-07-31 04:05:30
     * action : 1
     * hrefUrl :
     * productNO : 642
     */

    private List<DataBean> data;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ResultBean {
        private int code;
        private Object message;
        private int sampleTime;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

        public int getSampleTime() {
            return sampleTime;
        }

        public void setSampleTime(int sampleTime) {
            this.sampleTime = sampleTime;
        }
    }

    public static class DataBean {
        private String title;
        private String content;
        private int infoId;
        private int userId;
        private int catId;
        private String imgUrl;
        private int shareCount;
        private int keepCount;
        private int likeCount;
        private int scannedCount;
        private String createdAt;
        private String updatedAt;
        private int action;
        private String hrefUrl;
        private int productNO;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getCatId() {
            return catId;
        }

        public void setCatId(int catId) {
            this.catId = catId;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getKeepCount() {
            return keepCount;
        }

        public void setKeepCount(int keepCount) {
            this.keepCount = keepCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getScannedCount() {
            return scannedCount;
        }

        public void setScannedCount(int scannedCount) {
            this.scannedCount = scannedCount;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getHrefUrl() {
            return hrefUrl;
        }

        public void setHrefUrl(String hrefUrl) {
            this.hrefUrl = hrefUrl;
        }

        public int getProductNO() {
            return productNO;
        }

        public void setProductNO(int productNO) {
            this.productNO = productNO;
        }
    }
}
