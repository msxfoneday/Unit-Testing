package com.example.chuanjiang.unittest381;


import java.util.List;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class ShopDetail {
    public final String cartId;
    public final String cartType;
    public final String compId;
    public final String uniqueId;
    public final String empId;
    public final String totalAmt;
    public final String totalQuantity;
    public final String riskMarkCode;
    public final java.util.List<CmdtyList> cmdtyList;
    public final java.util.List<OrderTravelDto> orderTravelDto;
    public final java.util.List<TravelCompanInfoList> travelCompanInfoList;
    public final String crProdId;
    public final String isDownPmt;
    public final String promId;
    public final String minDownPmt;
    public final String maxDownPmt;

    public ShopDetail(String cartId, String cartType, String compId, String uniqueId, String empId, String totalAmt, String totalQuantity, String riskMarkCode, List<CmdtyList> cmdtyList, List<OrderTravelDto> orderTravelDto, List<TravelCompanInfoList> travelCompanInfoList, String crProdId, String isDownPmt, String promId, String minDownPmt, String maxDownPmt) {
        this.cartId = cartId;
        this.cartType = cartType;
        this.compId = compId;
        this.uniqueId = uniqueId;
        this.empId = empId;
        this.totalAmt = totalAmt;
        this.totalQuantity = totalQuantity;
        this.riskMarkCode = riskMarkCode;
        this.cmdtyList = cmdtyList;
        this.orderTravelDto = orderTravelDto;
        this.travelCompanInfoList = travelCompanInfoList;
        this.crProdId = crProdId;
        this.isDownPmt = isDownPmt;
        this.promId = promId;
        this.minDownPmt = minDownPmt;
        this.maxDownPmt = maxDownPmt;
    }

    @Override
    public String toString() {
        return "ShopDetail{" +
                "cartId='" + cartId + '\'' +
                ", cartType='" + cartType + '\'' +
                ", compId='" + compId + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", empId='" + empId + '\'' +
                ", totalAmt='" + totalAmt + '\'' +
                ", totalQuantity='" + totalQuantity + '\'' +
                ", riskMarkCode='" + riskMarkCode + '\'' +
                ", cmdtyList=" + cmdtyList +
                ", orderTravelDto=" + orderTravelDto +
                ", travelCompanInfoList=" + travelCompanInfoList +
                ", crProdId='" + crProdId + '\'' +
                ", isDownPmt='" + isDownPmt + '\'' +
                ", promId='" + promId + '\'' +
                ", minDownPmt='" + minDownPmt + '\'' +
                ", maxDownPmt='" + maxDownPmt + '\'' +
                '}';
    }

    static class CmdtyList {

        public final String catId;
        public final String cmdtyId;
        public final String brandName;
        public final String cmdtyName;
        public final String pcsCount;
        public final String cmdtyPrice;

        public CmdtyList(String catId, String cmdtyId, String brandName, String cmdtyName, String pcsCount, String cmdtyPrice) {
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
                    ", cmdtyPrice='" + cmdtyPrice + '\'' +
                    '}';
        }
    }


    static class OrderTravelDto {

        public final String departureTime;
        public final String returnTime;
        public final String isNeedVisa;
        public final String origin;
        public final String destination;
        public final String travelNum;
        public final String travelKidsNum;
        public final String travelType;

        public OrderTravelDto(String departureTime, String returnTime, String isNeedVisa, String origin, String destination, String travelNum, String travelKidsNum, String travelType) {
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
                    ", travelNum='" + travelNum + '\'' +
                    ", travelKidsNum='" + travelKidsNum + '\'' +
                    ", travelType='" + travelType + '\'' +
                    '}';
        }
    }

    static class TravelCompanInfoList {

        public final String companName;
        public final String companCellphone;
        public final String companCertId;
        public final String companRelationship;

        public TravelCompanInfoList(String companName, String companCellphone, String companCertId, String companRelationship) {
            this.companName = companName;
            this.companCellphone = companCellphone;
            this.companCertId = companCertId;
            this.companRelationship = companRelationship;
        }

        @Override
        public String toString() {
            return "TravelCompanInfoList{" +
                    "companName='" + companName + '\'' +
                    ", companCellphone='" + companCellphone + '\'' +
                    ", companCertId='" + companCertId + '\'' +
                    ", companRelationship='" + companRelationship + '\'' +
                    '}';
        }
    }



}
