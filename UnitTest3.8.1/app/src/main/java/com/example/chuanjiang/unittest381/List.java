package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class List {
    public final int count;
    public final int pageSize;
    public final int pageNo;
    public final java.util.List<OrderList> orderList;

    public List(int count, int pageSize, int pageNo, java.util.List<OrderList> orderList) {
        this.count = count;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "List{" +
                "count=" + count +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", orderList=" + orderList +
                '}';
    }

    static class OrderList {
        public final String inOrderId;
        public final double totalAmt;
        public final int totalQuantity;
        public final String orderStatus;
        public final int orderTime;
        public final int isDownPmt;
        public final java.util.List<CmdtyList> cmdtyList;

        public OrderList(String inOrderId, double totalAmt, int totalQuantity, String orderStatus, int orderTime, int isDownPmt, java.util.List<CmdtyList> cmdtyList) {
            this.inOrderId = inOrderId;
            this.totalAmt = totalAmt;
            this.totalQuantity = totalQuantity;
            this.orderStatus = orderStatus;
            this.orderTime = orderTime;
            this.isDownPmt = isDownPmt;
            this.cmdtyList = cmdtyList;
        }

        @Override
        public String toString() {
            return "OrderList{" +
                    "inOrderId='" + inOrderId + '\'' +
                    ", totalAmt=" + totalAmt +
                    ", totalQuantity=" + totalQuantity +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", orderTime=" + orderTime +
                    ", isDownPmt=" + isDownPmt +
                    ", cmdtyList=" + cmdtyList +
                    '}';
        }

        static class CmdtyList {
            public final String catId;
            public final String cmdtyId;
            public final String brandName;
            public final String cmdtyName;
            public final int pcsCount;
            public final double cmdtyPrice;

            public CmdtyList(String catId, String cmdtyId, String brandName, String cmdtyName, int pcsCount, double cmdtyPrice) {
                this.catId = catId;
                this.cmdtyId = cmdtyId;
                this.brandName = brandName;
                this.cmdtyName = cmdtyName;
                this.pcsCount = pcsCount;
                this.cmdtyPrice = cmdtyPrice;
            }

            @Override
            public String toString() {
                return "CmdtyList{" +
                        "catId='" + catId + '\'' +
                        ", cmdtyId='" + cmdtyId + '\'' +
                        ", brandName='" + brandName + '\'' +
                        ", cmdtyName='" + cmdtyName + '\'' +
                        ", pcsCount=" + pcsCount +
                        ", cmdtyPrice=" + cmdtyPrice +
                        '}';
            }
        }
    }


}
