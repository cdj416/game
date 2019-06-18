package com.alipayjf.game.entity;

public class LoginBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"token":"a18fe71468d5488c8e35e35f5391cf7d","username":"18183185173"}
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
         * token : a18fe71468d5488c8e35e35f5391cf7d
         * username : 18183185173
         */

        private String token;
        private String username;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
