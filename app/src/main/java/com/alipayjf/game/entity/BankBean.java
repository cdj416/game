package com.alipayjf.game.entity;

public class BankBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"id":11,"cardNo":"6216911108575015","address":"中国民生银行重庆分行渝北支行","maxValue":5000000,"usableValue":5000000,"bankId":10,"cardName":"程小芹","bankName":null}
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
         * id : 11
         * cardNo : 6216911108575015
         * address : 中国民生银行重庆分行渝北支行
         * maxValue : 5000000
         * usableValue : 5000000
         * bankId : 10
         * cardName : 程小芹
         * bankName : null
         */

        private int id;
        private String cardNo;
        private String address;
        private int maxValue;
        private int usableValue;
        private int bankId;
        private String cardName;
        private Object bankName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        public int getUsableValue() {
            return usableValue;
        }

        public void setUsableValue(int usableValue) {
            this.usableValue = usableValue;
        }

        public int getBankId() {
            return bankId;
        }

        public void setBankId(int bankId) {
            this.bankId = bankId;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public Object getBankName() {
            return bankName;
        }

        public void setBankName(Object bankName) {
            this.bankName = bankName;
        }
    }
}
