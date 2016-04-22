package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class Consume {
    public final String orderNo;

    public Consume(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "Consume{" +
                "orderNo='" + orderNo + '\'' +
                '}';
    }
}
