package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class CheckSms {
    public final String smsSeqNo;

    public CheckSms(String smsSeqNo) {
        this.smsSeqNo = smsSeqNo;
    }

    @Override
    public String toString() {
        return "CheckSms{" +
                "smsSeqNo='" + smsSeqNo + '\'' +
                '}';
    }
}
