package com.alipayjf.game.entity;

public class FillrechargeAcountBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"id":100090,"chargeFee":10000,"status":-1,"bankId":null,"bankCardId":null,"createdTime":"2019-06-15 16:12:47","updatedTime":null,"userId":"14","username":null,"bankName":null,"cardNo":null,"cardName":null}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 100090
         * chargeFee : 10000
         * status : -1
         * bankId : null
         * bankCardId : null
         * createdTime : 2019-06-15 16:12:47
         * updatedTime : null
         * userId : 14
         * username : null
         * bankName : null
         * cardNo : null
         * cardName : null
         */

        private int id;
        private int chargeFee;
        private int status;
        private Object bankId;
        private Object bankCardId;
        private String createdTime;
        private Object updatedTime;
        private String userId;
        private Object username;
        private Object bankName;
        private Object cardNo;
        private Object cardName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getChargeFee() {
            return chargeFee;
        }

        public void setChargeFee(int chargeFee) {
            this.chargeFee = chargeFee;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getBankId() {
            return bankId;
        }

        public void setBankId(Object bankId) {
            this.bankId = bankId;
        }

        public Object getBankCardId() {
            return bankCardId;
        }

        public void setBankCardId(Object bankCardId) {
            this.bankCardId = bankCardId;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public Object getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(Object updatedTime) {
            this.updatedTime = updatedTime;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public Object getBankName() {
            return bankName;
        }

        public void setBankName(Object bankName) {
            this.bankName = bankName;
        }

        public Object getCardNo() {
            return cardNo;
        }

        public void setCardNo(Object cardNo) {
            this.cardNo = cardNo;
        }

        public Object getCardName() {
            return cardName;
        }

        public void setCardName(Object cardName) {
            this.cardName = cardName;
        }
    }
}
