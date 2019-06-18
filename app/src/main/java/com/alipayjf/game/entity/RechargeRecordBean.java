package com.alipayjf.game.entity;

import java.util.List;

public class RechargeRecordBean {

    /**
     * code : 200
     * message : 操作成功
     * result : {"total":3,"list":[{"id":100079,"chargeFee":1000,"status":0,"bankId":8,"bankCardId":10,"createdTime":"2019-06-14 17:30:04","updatedTime":"2019-06-14 17:30:54","userId":"14","username":"17784495260","bankName":"兴业银行","cardNo":"622908343046378418","cardName":"程小芹"},{"id":100078,"chargeFee":100000,"status":0,"bankId":8,"bankCardId":10,"createdTime":"2019-06-12 16:24:26","updatedTime":"2019-06-12 16:24:29","userId":"14","username":"17784495260","bankName":"兴业银行","cardNo":"622908343046378418","cardName":"程小芹"},{"id":100073,"chargeFee":100000,"status":1,"bankId":8,"bankCardId":10,"createdTime":"2019-06-12 09:44:52","updatedTime":"2019-06-12 09:45:09","userId":"14","username":"17784495260","bankName":"兴业银行","cardNo":"622908343046378418","cardName":"程小芹"}],"pageNum":1,"pageSize":10,"size":3,"startRow":1,"endRow":3,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 3
         * list : [{"id":100079,"chargeFee":1000,"status":0,"bankId":8,"bankCardId":10,"createdTime":"2019-06-14 17:30:04","updatedTime":"2019-06-14 17:30:54","userId":"14","username":"17784495260","bankName":"兴业银行","cardNo":"622908343046378418","cardName":"程小芹"},{"id":100078,"chargeFee":100000,"status":0,"bankId":8,"bankCardId":10,"createdTime":"2019-06-12 16:24:26","updatedTime":"2019-06-12 16:24:29","userId":"14","username":"17784495260","bankName":"兴业银行","cardNo":"622908343046378418","cardName":"程小芹"},{"id":100073,"chargeFee":100000,"status":1,"bankId":8,"bankCardId":10,"createdTime":"2019-06-12 09:44:52","updatedTime":"2019-06-12 09:45:09","userId":"14","username":"17784495260","bankName":"兴业银行","cardNo":"622908343046378418","cardName":"程小芹"}]
         * pageNum : 1
         * pageSize : 10
         * size : 3
         * startRow : 1
         * endRow : 3
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
             * id : 100079
             * chargeFee : 1000
             * status : 0
             * bankId : 8
             * bankCardId : 10
             * createdTime : 2019-06-14 17:30:04
             * updatedTime : 2019-06-14 17:30:54
             * userId : 14
             * username : 17784495260
             * bankName : 兴业银行
             * cardNo : 622908343046378418
             * cardName : 程小芹
             */

            private int id;
            private int chargeFee;
            private int status;
            private int bankId;
            private int bankCardId;
            private String createdTime;
            private String updatedTime;
            private String userId;
            private String username;
            private String bankName;
            private String cardNo;
            private String cardName;

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

            public int getBankId() {
                return bankId;
            }

            public void setBankId(int bankId) {
                this.bankId = bankId;
            }

            public int getBankCardId() {
                return bankCardId;
            }

            public void setBankCardId(int bankCardId) {
                this.bankCardId = bankCardId;
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

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
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

            public String getCardName() {
                return cardName;
            }

            public void setCardName(String cardName) {
                this.cardName = cardName;
            }
        }
    }
}
