package com.alipayjf.game.entity;

public class RenZhengBean {


    /**
     * id : 28
     * wxFile : {"url":"http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F6097c2d3-d5d1-4794-8db4-f7502199f8c5.jpg"}
     * zfbFile : {"url":"http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F4f5e595c-8a1d-4394-94a0-81f5d6fcc9d6.jpg"}
     */

    private String id;
    private WxFileBean wxFile;
    private ZfbFileBean zfbFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WxFileBean getWxFile() {
        return wxFile;
    }

    public void setWxFile(WxFileBean wxFile) {
        this.wxFile = wxFile;
    }

    public ZfbFileBean getZfbFile() {
        return zfbFile;
    }

    public void setZfbFile(ZfbFileBean zfbFile) {
        this.zfbFile = zfbFile;
    }

    public static class WxFileBean {
        /**
         * url : http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F6097c2d3-d5d1-4794-8db4-f7502199f8c5.jpg
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ZfbFileBean {
        /**
         * url : http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F4f5e595c-8a1d-4394-94a0-81f5d6fcc9d6.jpg
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
