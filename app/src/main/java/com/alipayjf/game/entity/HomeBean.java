package com.alipayjf.game.entity;

import java.util.List;

public class HomeBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"total":8,"list":[{"id":111,"companyId":10005,"createdTime":"2019-06-12 10:39:01","appUserId":14,"merchantOrderNo":"1560307141267","orderNo":"201906121039015643","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":109,"companyId":10005,"createdTime":"2019-06-12 10:38:10","appUserId":14,"merchantOrderNo":"1560307089949","orderNo":"201906121038097776","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":107,"companyId":10005,"createdTime":"2019-06-12 10:36:06","appUserId":14,"merchantOrderNo":"1560306965576","orderNo":"201906121036056898","totalFee":10000,"payType":"alipay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":106,"companyId":10005,"createdTime":"2019-06-12 10:35:31","appUserId":14,"merchantOrderNo":"1560306930722","orderNo":"201906121035306134","totalFee":10000,"payType":"alipay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":105,"companyId":10005,"createdTime":"2019-06-12 10:34:50","appUserId":14,"merchantOrderNo":"1560306889769","orderNo":"201906121034497999","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":104,"companyId":10005,"createdTime":"2019-06-12 10:34:14","appUserId":14,"merchantOrderNo":"1560306854365","orderNo":"201906121034149845","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":103,"companyId":10005,"createdTime":"2019-06-12 10:19:56","appUserId":14,"merchantOrderNo":"1560305995603","orderNo":"201906121019551645","totalFee":20000,"payType":"alipay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":2,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":102,"companyId":10005,"createdTime":"2019-06-12 10:18:38","appUserId":14,"merchantOrderNo":"1560305917234","orderNo":"201906121018379344","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"}],"pageNum":1,"pageSize":10,"size":8,"startRow":1,"endRow":8,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 8
         * list : [{"id":111,"companyId":10005,"createdTime":"2019-06-12 10:39:01","appUserId":14,"merchantOrderNo":"1560307141267","orderNo":"201906121039015643","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":109,"companyId":10005,"createdTime":"2019-06-12 10:38:10","appUserId":14,"merchantOrderNo":"1560307089949","orderNo":"201906121038097776","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":107,"companyId":10005,"createdTime":"2019-06-12 10:36:06","appUserId":14,"merchantOrderNo":"1560306965576","orderNo":"201906121036056898","totalFee":10000,"payType":"alipay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":106,"companyId":10005,"createdTime":"2019-06-12 10:35:31","appUserId":14,"merchantOrderNo":"1560306930722","orderNo":"201906121035306134","totalFee":10000,"payType":"alipay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":105,"companyId":10005,"createdTime":"2019-06-12 10:34:50","appUserId":14,"merchantOrderNo":"1560306889769","orderNo":"201906121034497999","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":104,"companyId":10005,"createdTime":"2019-06-12 10:34:14","appUserId":14,"merchantOrderNo":"1560306854365","orderNo":"201906121034149845","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":103,"companyId":10005,"createdTime":"2019-06-12 10:19:56","appUserId":14,"merchantOrderNo":"1560305995603","orderNo":"201906121019551645","totalFee":20000,"payType":"alipay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":2,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"},{"id":102,"companyId":10005,"createdTime":"2019-06-12 10:18:38","appUserId":14,"merchantOrderNo":"1560305917234","orderNo":"201906121018379344","totalFee":10000,"payType":"wxpay","notifyUrl":"http://mqpayadmin.alipayjf.com/open/notify","status":1,"isNotify":1,"remark":"玩家充值","orderName":"第一次充值","begintime":null,"endtime":null,"username":"17784495260"}]
         * pageNum : 1
         * pageSize : 10
         * size : 8
         * startRow : 1
         * endRow : 8
         * pages : 1
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         */

        private int total;
        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 111
             * companyId : 10005
             * createdTime : 2019-06-12 10:39:01
             * appUserId : 14
             * merchantOrderNo : 1560307141267
             * orderNo : 201906121039015643
             * totalFee : 10000
             * payType : wxpay
             * notifyUrl : http://mqpayadmin.alipayjf.com/open/notify
             * status : 1
             * isNotify : 1
             * remark : 玩家充值
             * orderName : 第一次充值
             * begintime : null
             * endtime : null
             * username : 17784495260
             */

            private int id;
            private int companyId;
            private String createdTime;
            private int appUserId;
            private String merchantOrderNo;
            private String orderNo;
            private int totalFee;
            private String payType;
            private String notifyUrl;
            private int status;
            private int isNotify;
            private String remark;
            private String orderName;
            private Object begintime;
            private Object endtime;
            private String username;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCompanyId() {
                return companyId;
            }

            public void setCompanyId(int companyId) {
                this.companyId = companyId;
            }

            public String getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(String createdTime) {
                this.createdTime = createdTime;
            }

            public int getAppUserId() {
                return appUserId;
            }

            public void setAppUserId(int appUserId) {
                this.appUserId = appUserId;
            }

            public String getMerchantOrderNo() {
                return merchantOrderNo;
            }

            public void setMerchantOrderNo(String merchantOrderNo) {
                this.merchantOrderNo = merchantOrderNo;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public int getTotalFee() {
                return totalFee;
            }

            public void setTotalFee(int totalFee) {
                this.totalFee = totalFee;
            }

            public String getPayType() {
                return payType;
            }

            public void setPayType(String payType) {
                this.payType = payType;
            }

            public String getNotifyUrl() {
                return notifyUrl;
            }

            public void setNotifyUrl(String notifyUrl) {
                this.notifyUrl = notifyUrl;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getIsNotify() {
                return isNotify;
            }

            public void setIsNotify(int isNotify) {
                this.isNotify = isNotify;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getOrderName() {
                return orderName;
            }

            public void setOrderName(String orderName) {
                this.orderName = orderName;
            }

            public Object getBegintime() {
                return begintime;
            }

            public void setBegintime(Object begintime) {
                this.begintime = begintime;
            }

            public Object getEndtime() {
                return endtime;
            }

            public void setEndtime(Object endtime) {
                this.endtime = endtime;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
