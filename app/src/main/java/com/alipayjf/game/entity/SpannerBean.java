package com.alipayjf.game.entity;

import java.util.List;

public class SpannerBean {

    /**
     * code : 200
     * message : 操作成功
     * result : [{"id":8,"name":"兴业银行"},{"id":10,"name":"中国民生银行"},{"id":9,"name":"中信银行"},{"id":11,"name":"招商银行"},{"id":12,"name":"中国农业银行"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 8
         * name : 兴业银行
         */

        private int id;
        private String name;
        private boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
