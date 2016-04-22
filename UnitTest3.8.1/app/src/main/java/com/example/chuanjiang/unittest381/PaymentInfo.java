package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class PaymentInfo {
    public final Long bankCardId;
    public final String bankCode;
    public final String bankName;
    public final String bankCardType;
    public final String bankCardNo;
    public final String authId;
    public final double downPmt;

    public PaymentInfo(Long bankCardId, String bankCode, String bankName, String bankCardType, String bankCardNo, String authId, double downPmt) {
        this.bankCardId = bankCardId;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.bankCardType = bankCardType;
        this.bankCardNo = bankCardNo;
        this.authId = authId;
        this.downPmt = downPmt;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "bankCardId=" + bankCardId +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCardType='" + bankCardType + '\'' +
                ", bankCardNo='" + bankCardNo + '\'' +
                ", authId='" + authId + '\'' +
                ", downPmt=" + downPmt +
                '}';
    }
}
