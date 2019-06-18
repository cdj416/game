package com.alipayjf.game.entity;

import java.util.List;

public class ReflectiveRecordBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"total":9,"list":[{"id":29,"status":1,"createdTime":"2019-06-14 22:03:24","updatedTime":null,"userId":14,"totalFee":900,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":28,"status":1,"createdTime":"2019-06-14 22:03:00","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":27,"status":1,"createdTime":"2019-06-14 22:02:35","updatedTime":null,"userId":14,"totalFee":1000,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":26,"status":1,"createdTime":"2019-06-14 22:00:48","updatedTime":null,"userId":14,"totalFee":900,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":25,"status":1,"createdTime":"2019-06-14 22:00:00","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":24,"status":1,"createdTime":"2019-06-14 21:59:13","updatedTime":null,"userId":14,"totalFee":2000,"remark":"到账了","depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":23,"status":1,"createdTime":"2019-06-14 21:49:21","updatedTime":null,"userId":14,"totalFee":1000,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":22,"status":1,"createdTime":"2019-06-14 21:46:52","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":21,"status":1,"createdTime":"2019-06-14 21:43:34","updatedTime":null,"userId":14,"totalFee":1000,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"}],"pageNum":1,"pageSize":10,"size":9,"startRow":1,"endRow":9,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 9
         * list : [{"id":29,"status":1,"createdTime":"2019-06-14 22:03:24","updatedTime":null,"userId":14,"totalFee":900,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":28,"status":1,"createdTime":"2019-06-14 22:03:00","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":27,"status":1,"createdTime":"2019-06-14 22:02:35","updatedTime":null,"userId":14,"totalFee":1000,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":26,"status":1,"createdTime":"2019-06-14 22:00:48","updatedTime":null,"userId":14,"totalFee":900,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":25,"status":1,"createdTime":"2019-06-14 22:00:00","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":24,"status":1,"createdTime":"2019-06-14 21:59:13","updatedTime":null,"userId":14,"totalFee":2000,"remark":"到账了","depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":23,"status":1,"createdTime":"2019-06-14 21:49:21","updatedTime":null,"userId":14,"totalFee":1000,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":22,"status":1,"createdTime":"2019-06-14 21:46:52","updatedTime":null,"userId":14,"totalFee":100,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"},{"id":21,"status":1,"createdTime":"2019-06-14 21:43:34","updatedTime":null,"userId":14,"totalFee":1000,"remark":null,"depositBankName":"5215","bankName":"342134","cardNo":"1342342341","accountName":"aa","username":"17784495260"}]
         * pageNum : 1
         * pageSize : 10
         * size : 9
         * startRow : 1
         * endRow : 9
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
             * id : 29
             * status : 1
             * createdTime : 2019-06-14 22:03:24
             * updatedTime : null
             * userId : 14
             * totalFee : 900
             * remark : null
             * depositBankName : 5215
             * bankName : 342134
             * cardNo : 1342342341
             * accountName : aa
             * username : 17784495260
             */

            private int id;
            private int status;
            private String createdTime;
            private Object updatedTime;
            private int userId;
            private int totalFee;
            private Object remark;
            private String depositBankName;
            private String bankName;
            private String cardNo;
            private String accountName;
            private String username;

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

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
