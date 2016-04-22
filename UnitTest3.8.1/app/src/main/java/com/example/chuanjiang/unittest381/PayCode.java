package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class PayCode {

    public final String authType;
    public final String authId;
    public final String authCode;
    public final String expireDate;
    public final Double downPmt;

    public PayCode(String authType, String authId, String authCode, String expireDate, Double downPmt) {
        this.authType = authType;
        this.authId = authId;
        this.authCode = authCode;
        this.expireDate = expireDate;
        this.downPmt = downPmt;
    }

    @Override
    public String toString() {
        return "PayCode{" +
                "authType='" + authType + '\'' +
                ", authId='" + authId + '\'' +
                ", authCode='" + authCode + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", downPmt=" + downPmt +
                '}';
    }
}
