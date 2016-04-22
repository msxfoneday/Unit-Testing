package com.example.chuanjiang.unittest381;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public interface CouponApi {
    @GET("coupon/couponsList")
    Observable<CouponsList> getCouponList(@Query("status")String status);

    @GET("coupon/couponBind")
    Observable<CouponBind> getCouponBind(@Query("code")String code);
}
