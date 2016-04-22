package com.example.chuanjiang.unittest381;

import android.webkit.JavascriptInterface;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class Detail {
    public final String inOrderId;
    public final String orderStatus;
    public final String orderTime;
    public final String txnTime;
    public final String compId;
    public final String empId;
    public final String compName;
    public final String compOfficePhone;
    public final String empName;
    public final String outOrderId;
    public final String catId;
    public final String cartType;
    public final double totalAmt;
    public final String totalQuantity;
    public final String uniqueId;
    public final String custName;
    public final String cellphone;
    public final String appId;
    public final String contractId;
    public final String crProdId;
    public final String crProName;
    public final String curCode;
    public final String loanAmt;
    public final String loanTerm;
    public final double mthlyPmtAmt;
    public final int isDownPmt;
    public final double downPmtPct;
    public final double downPmt;
    public final int valueAddeSvc;
    public final java.util.List<CmdtyList> cmdtyList;
    public final java.util.List<OrderTravelDto> orderTravelDto;
    public final java.util.List<TravelCompanDtoList> travelCompanDtoList;

    public Detail(String inOrderId, String orderStatus, String orderTime, String txnTime, String compId, String empId, String compName, String compOfficePhone, String empName, String outOrderId, String catId, String cartType, double totalAmt, String totalQuantity, String uniqueId, String custName, String cellphone, String appId, String contractId, String crProdId, String crProName, String curCode, String loanAmt, String loanTerm, double mthlyPmtAmt, int isDownPmt, double downPmtPct, double downPmt, int valueAddeSvc, java.util.List<CmdtyList> cmdtyList, java.util.List<OrderTravelDto> orderTravelDto, java.util.List<TravelCompanDtoList> travelCompanDtoList) {
        this.inOrderId = inOrderId;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
        this.txnTime = txnTime;
        this.compId = compId;
        this.empId = empId;
        this.compName = compName;
        this.compOfficePhone = compOfficePhone;
        this.empName = empName;
        this.outOrderId = outOrderId;
        this.catId = catId;
        this.cartType = cartType;
        this.totalAmt = totalAmt;
        this.totalQuantity = totalQuantity;
        this.uniqueId = uniqueId;
        this.custName = custName;
        this.cellphone = cellphone;
        this.appId = appId;
        this.contractId = contractId;
        this.crProdId = crProdId;
        this.crProName = crProName;
        this.curCode = curCode;
        this.loanAmt = loanAmt;
        this.loanTerm = loanTerm;
        this.mthlyPmtAmt = mthlyPmtAmt;
        this.isDownPmt = isDownPmt;
        this.downPmtPct = downPmtPct;
        this.downPmt = downPmt;
        this.valueAddeSvc = valueAddeSvc;
        this.cmdtyList = cmdtyList;
        this.orderTravelDto = orderTravelDto;
        this.travelCompanDtoList = travelCompanDtoList;
    }


    static class CmdtyList {
        public final String catId;
        public final String cmdtyId;
        public final String brandName;
        public final String cmdtyName;
        public final String pcsCount;
        public final double cmdtyPrice;

        public CmdtyList(String catId, String cmdtyId, String brandName, String cmdtyName, String pcsCount, double cmdtyPrice) {
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
                    ", pcsCount='" + pcsCount + '\'' +
                    ", cmdtyPrice=" + cmdtyPrice +
                    '}';
        }
    }

    static class OrderTravelDto {
        public final String departureTime;
        public final String returnTime;
        public final String isNeedVisa;
        public final String origin;
        public final String destination;
        public final int travelNum;
        public final int travelKidsNum;
        public final String travelType;

        public OrderTravelDto(String departureTime, String returnTime, String isNeedVisa, String origin, String destination, int travelNum, int travelKidsNum, String travelType) {
            this.departureTime = departureTime;
            this.returnTime = returnTime;
            this.isNeedVisa = isNeedVisa;
            this.origin = origin;
            this.destination = destination;
            this.travelNum = travelNum;
            this.travelKidsNum = travelKidsNum;
            this.travelType = travelType;
        }

        @Override
        public String toString() {
            return "OrderTravelDto{" +
                    "departureTime='" + departureTime + '\'' +
                    ", returnTime='" + returnTime + '\'' +
                    ", isNeedVisa='" + isNeedVisa + '\'' +
                    ", origin='" + origin + '\'' +
                    ", destination='" + destination + '\'' +
                    ", travelNum=" + travelNum +
                    ", travelKidsNum=" + travelKidsNum +
                    ", travelType='" + travelType + '\'' +
                    '}';
        }
    }

    static class TravelCompanDtoList {
        public final String companName;
        public final String companCellphone;
        public final String companCertId;
        public final String companRelationship;

        public TravelCompanDtoList(String companName, String companCellphone, String companCertId, String companRelationship) {
            this.companName = companName;
            this.companCellphone = companCellphone;
            this.companCertId = companCertId;
            this.companRelationship = companRelationship;
        }

        @Override
        public String toString() {
            return "TravelCompanDtoList{" +
                    "companName='" + companName + '\'' +
                    ", companCellphone='" + companCellphone + '\'' +
                    ", companCertId='" + companCertId + '\'' +
                    ", companRelationship='" + companRelationship + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Detail{" +
                "inOrderId='" + inOrderId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", txnTime='" + txnTime + '\'' +
                ", compId='" + compId + '\'' +
                ", empId='" + empId + '\'' +
                ", compName='" + compName + '\'' +
                ", compOfficePhone='" + compOfficePhone + '\'' +
                ", empName='" + empName + '\'' +
                ", outOrderId='" + outOrderId + '\'' +
                ", catId='" + catId + '\'' +
                ", cartType='" + cartType + '\'' +
                ", totalAmt=" + totalAmt +
                ", totalQuantity='" + totalQuantity + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", custName='" + custName + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", appId='" + appId + '\'' +
                ", contractId='" + contractId + '\'' +
                ", crProdId='" + crProdId + '\'' +
                ", crProName='" + crProName + '\'' +
                ", curCode='" + curCode + '\'' +
                ", loanAmt='" + loanAmt + '\'' +
                ", loanTerm='" + loanTerm + '\'' +
                ", mthlyPmtAmt=" + mthlyPmtAmt +
                ", isDownPmt=" + isDownPmt +
                ", downPmtPct=" + downPmtPct +
                ", downPmt=" + downPmt +
                ", valueAddeSvc=" + valueAddeSvc +
                ", cmdtyList=" + cmdtyList +
                ", orderTravelDto=" + orderTravelDto +
                ", travelCompanDtoList=" + travelCompanDtoList +
                '}';
    }
}
