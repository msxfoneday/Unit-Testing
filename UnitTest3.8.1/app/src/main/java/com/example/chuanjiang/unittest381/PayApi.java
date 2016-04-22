package com.example.chuanjiang.unittest381;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public interface PayApi {
    @FormUrlEncoded
    @POST("pay/checkData")
    Observable<CheckData> getCheckData(@Field("transPassword") String transPassword, @Field("contractNo") String contractNo);

    @POST("pay/checkSms")
    Observable<CheckSms> getCheckSms();

    @FormUrlEncoded
    @POST("pay/consume")
    Observable<Consume> getConsume(@Field("amount") String amount, @Field("smsCode") String smsCode, @Field("smsSeqNo") String smsSeqNo, @Field("contractNo") String contractNo, @Field("bankCardId") Long bankCardId, @Field("transPassword") String transPassword);

    @FormUrlEncoded
    @POST("pay/paymentInfo")
    Observable<PaymentInfo> getPaymentInfo(@Field("transPassword") String transPassword, @Field("authType") String authType, @Field("authId") String authId);

    @FormUrlEncoded
    @POST("pay/downPayment")
    Observable<DownPayment> getDownPayment(@Field("inOrderId") String inOrderId, @Field("smsCode") String smsCode, @Field("smsSeqNo") String smsSeqNo, @Field("downPmt") String downPmt, @Field("bankCardId") Long bankCardId);

    @FormUrlEncoded
    @POST("pay/makeLoans")
    Observable<MakeLoans> getMakeLoans(@Field("inOrderId") String inOrderId);

    @FormUrlEncoded
    @POST("pay/drawings")
    Observable<Drawings> getDrawings(@Field("drawingAmount") String drawingAmount, @Field("contractNo") String contractNo, @Field("bankCardId") Long bankCardId, @Field("dealPwd") String dealPwd);

    @FormUrlEncoded
    @POST("pay/repayInfo")
    Observable<RepayInfo> getRepayInfo(@Field("contractNo") String contract, @Field("type") String type);
}
