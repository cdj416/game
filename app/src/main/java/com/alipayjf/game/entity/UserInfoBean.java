package com.alipayjf.game.entity;

public class UserInfoBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"id":14,"username":"17784495260","password":"e10adc3949ba59abbe56e057f20f883e","status":2,"createdTime":"2019-06-11 17:34:06","updatedTime":"2019-06-14 20:46:11","onlineTime":"2019-06-12 16:24:15","lastTime":"2019-06-12 10:38:10","user_status":0,"wxCodeUrl":"http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F2cb7569c-21b6-4e51-b40d-6df568f9268e.png","zfbCodeUrl":"http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F0e7406e8-23d3-4678-958c-a06f94390d3e.jpg","total_points":1000,"earn_points":1000,"order_status":0,"badRecord":4,"valid":1,"maxFee":200000,"minFee":1000,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","remark":null,"validateKey":null,"validateCode":null,"fileList":null,"wxFile":null,"zfbFile":null,"oldPassword":null}
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
         * id : 14
         * username : 17784495260
         * password : e10adc3949ba59abbe56e057f20f883e
         * status : 2
         * createdTime : 2019-06-11 17:34:06
         * updatedTime : 2019-06-14 20:46:11
         * onlineTime : 2019-06-12 16:24:15
         * lastTime : 2019-06-12 10:38:10
         * user_status : 0
         * wxCodeUrl : http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F2cb7569c-21b6-4e51-b40d-6df568f9268e.png
         * zfbCodeUrl : http://syl-estate.oss-cn-shenzhen.aliyuncs.com/pay_img%2F0e7406e8-23d3-4678-958c-a06f94390d3e.jpg
         * total_points : 1000
         * earn_points : 1000
         * order_status : 0
         * badRecord : 4
         * valid : 1
         * maxFee : 200000
         * minFee : 1000
         * depositBankName : 5215
         * bankName : 342134
         * cardNo : 1342342341
         * accountName : aa
         * remark : null
         * validateKey : null
         * validateCode : null
         * fileList : null
         * wxFile : null
         * zfbFile : null
         * oldPassword : null
         */

        private int id;
        private String username;
        private String password;
        private int status;
        private String createdTime;
        private String updatedTime;
        private String onlineTime;
        private String lastTime;
        private int user_status;
        private String wxCodeUrl;
        private String zfbCodeUrl;
        private int total_points;
        private int earn_points;
        private int order_status;
        private int badRecord;
        private int valid;
        private long maxFee;
        private long minFee;
        private String depositBankName;
        private String bankName;
        private String cardNo;
        private String accountName;
        private Object remark;
        private Object validateKey;
        private Object validateCode;
        private Object fileList;
        private Object wxFile;
        private Object zfbFile;
        private Object oldPassword;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(String updatedTime) {
            this.updatedTime = updatedTime;
        }

        public String getOnlineTime() {
            return onlineTime;
        }

        public void setOnlineTime(String onlineTime) {
            this.onlineTime = onlineTime;
        }

        public String getLastTime() {
            return lastTime;
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }

        public int getUser_status() {
            return user_status;
        }

        public void setUser_status(int user_status) {
            this.user_status = user_status;
        }

        public String getWxCodeUrl() {
            return wxCodeUrl;
        }

        public void setWxCodeUrl(String wxCodeUrl) {
            this.wxCodeUrl = wxCodeUrl;
        }

        public String getZfbCodeUrl() {
            return zfbCodeUrl;
        }

        public void setZfbCodeUrl(String zfbCodeUrl) {
            this.zfbCodeUrl = zfbCodeUrl;
        }

        public int getTotal_points() {
            return total_points;
        }

        public void setTotal_points(int total_points) {
            this.total_points = total_points;
        }

        public int getEarn_points() {
            return earn_points;
        }

        public void setEarn_points(int earn_points) {
            this.earn_points = earn_points;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getBadRecord() {
            return badRecord;
        }

        public void setBadRecord(int badRecord) {
            this.badRecord = badRecord;
        }

        public int getValid() {
            return valid;
        }

        public void setValid(int valid) {
            this.valid = valid;
        }

        public long getMaxFee() {
            return maxFee;
        }

        public void setMaxFee(long maxFee) {
            this.maxFee = maxFee;
        }

        public long getMinFee() {
            return minFee;
        }

        public void setMinFee(long minFee) {
            this.minFee = minFee;
        }

        public String getDepositBankName() {
            return depositBankName;
        }

        public void setDepositBankName(String depositBankName) {
            this.depositBankName = depositBankName;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getValidateKey() {
            return validateKey;
        }

        public void setValidateKey(Object validateKey) {
            this.validateKey = validateKey;
        }

        public Object getValidateCode() {
            return validateCode;
        }

        public void setValidateCode(Object validateCode) {
            this.validateCode = validateCode;
        }

        public Object getFileList() {
            return fileList;
        }

        public void setFileList(Object fileList) {
            this.fileList = fileList;
        }

        public Object getWxFile() {
            return wxFile;
        }

        public void setWxFile(Object wxFile) {
            this.wxFile = wxFile;
        }

        public Object getZfbFile() {
            return zfbFile;
        }

        public void setZfbFile(Object zfbFile) {
            this.zfbFile = zfbFile;
        }

        public Object getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(Object oldPassword) {
            this.oldPassword = oldPassword;
        }
    }
}