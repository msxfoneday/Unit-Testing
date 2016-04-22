package com.example.chuanjiang.unittest381;



/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class CreateOrder {
    public final String appNo;

    public CreateOrder(String appNo) {
        this.appNo = appNo;
    }

    @Override
    public String toString() {
        return "CreateOrder{" +
                "appNo='" + appNo + '\'' +
                '}';
    }
}
