package com.example.chuanjiang.unittest381;

import java.util.Date;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class CouponsList {
    public final String id;
    public final long ticketRuleId;
    public final String ticketName;
    public final String type;
    public final String phone;
    public final String receiveTime;
    public final String receiveChannel;
    public final String effectDateBegin;
    public final String effectDate;
    public final String status;

    public CouponsList(String id, long ticketRuleId, String ticketName, String type, String phone, String receiveTime, String receiveChannel, String effectDateBegin, String effectDate, String status) {
        this.id = id;
        this.ticketRuleId = ticketRuleId;
        this.ticketName = ticketName;
        this.type = type;
        this.phone = phone;
        this.receiveTime = receiveTime;
        this.receiveChannel = receiveChannel;
        this.effectDateBegin = effectDateBegin;
        this.effectDate = effectDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "CouponsList{" +
                "id='" + id + '\'' +
                ", ticketRuleId=" + ticketRuleId +
                ", ticketName='" + ticketName + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", receiveTime=" + receiveTime +
                ", receiveChannel='" + receiveChannel + '\'' +
                ", effectDateBegin=" + effectDateBegin +
                ", effectDate=" + effectDate +
                ", status='" + status + '\'' +
                '}';
    }
}
