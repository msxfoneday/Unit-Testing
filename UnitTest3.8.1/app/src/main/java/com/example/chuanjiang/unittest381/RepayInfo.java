package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class RepayInfo {
    public final String contractNo;
    public final double latestDueMoney;
    public final String latestDueDate;
    public final double appLmt;
    public final int loanTerm;
    public final String loanCurrTerm;
    public final String loanExpireDate;
    public final double totalOverdueMoney;
    public final double interest;

    public RepayInfo(String contractNo, double latestDueMoney, String latestDueDate, double appLmt, int loanTerm, String loanCurrTerm, String loanExpireDate, double totalOverdueMoney, double interest) {
        this.contractNo = contractNo;
        this.latestDueMoney = latestDueMoney;
        this.latestDueDate = latestDueDate;
        this.appLmt = appLmt;
        this.loanTerm = loanTerm;
        this.loanCurrTerm = loanCurrTerm;
        this.loanExpireDate = loanExpireDate;
        this.totalOverdueMoney = totalOverdueMoney;
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "RepayInfo{" +
                "contractNo='" + contractNo + '\'' +
                ", latestDueMoney=" + latestDueMoney +
                ", latestDueDate='" + latestDueDate + '\'' +
                ", appLmt=" + appLmt +
                ", loanTerm=" + loanTerm +
                ", loanCurrTerm='" + loanCurrTerm + '\'' +
                ", loanExpireDate='" + loanExpireDate + '\'' +
                ", totalOverdueMoney=" + totalOverdueMoney +
                ", interest=" + interest +
                '}';
    }
}
