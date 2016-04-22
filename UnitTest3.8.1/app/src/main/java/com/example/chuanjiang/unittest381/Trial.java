package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class Trial {

    public final String loanFixedAmt;
    public final String lifeInsuranceAmt;
    public final String promId;

    public Trial(String loanFixedAmt, String lifeInsuranceAmt, String promId) {
        this.loanFixedAmt = loanFixedAmt;
        this.lifeInsuranceAmt = lifeInsuranceAmt;
        this.promId = promId;
    }

    @Override
    public String toString() {
        return "Trial{" +
                "loanFixedAmt='" + loanFixedAmt + '\'' +
                ", lifeInsuranceAmt='" + lifeInsuranceAmt + '\'' +
                ", promId='" + promId + '\'' +
                '}';
    }
}
