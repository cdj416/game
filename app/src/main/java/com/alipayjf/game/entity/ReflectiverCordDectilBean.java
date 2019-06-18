package com.alipayjf.game.entity;

public class ReflectiverCordDectilBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"id":39,"status":2,"createdTime":"2019-06-16 00:35:13","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":null,"bankName":null,"cardNo":null,"accountName":null,"username":null}
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
         * id : 39
         * status : 2
         * createdTime : 2019-06-16 00:35:13
         * updatedTime : null
         * userId : 14
         * totalFee : 100
         * remark : null
         * depositBankName : null
         * bankName : null
         * cardNo : null
         * accountName : null
         * username : null
         */

        private int id;
        private int status;
        private String createdTime;
        private Object updatedTime;
        private int userId;
        private int totalFee;
        private Object remark;
        private Object depositBankName;
        private Object bankName;
        private Object cardNo;
        private Object accountName;
        private Object username;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTotalFee() {
            return totalFee;
        }

        public void setTotalFee(int totalFee) {
            this.totalFee = totalFee;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getDepositBankName() {
            return depositBankName;
        }

        public void setDepositBankName(Object depositBankName) {
            this.depositBankName = depositBankName;
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

        public Object getAccountName() {
            return accountName;
        }

        public void setAccountName(Object accountName) {
            this.accountName = accountName;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }
    }
}
