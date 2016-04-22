package com.example.chuanjiang.unittest381;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public interface OrdersApi {
    @FormUrlEncoded
    @POST("orders/paycode")
    Observable<PayCode> getPayCode(@Field("transPassword") String transPassword, @Field("authType") String authType, @Field("authId") String authId);

    @GET("orders/list")
    Observable<List> getList(@Query("orderStatus") String orderStatus, @Query("pageSize") int pageSize, @Query("pageNo") int pageNo);

    @GET("orders/detail")
    Observable<Detail> getDetail(@Query("inOrderId") String inOrderId, @Query("appNo") String appNo);

    @GET("orders/shopdetail")
    Observable<ShopDetail> getShopDetail(@Query("cartId") String cartId);

    @FormUrlEncoded
    @POST("orders/createOrder")
    Observable<CreateOrder> getCreateOrder(@Field("applyStatus") String applyStatus, @Field("orderVO") JSONObject orderVO, @Field("accessoryInfoVO") JSONObject accessoryInfoVO, @Field("cartVO") JSONObject cartVO);

    @FormUrlEncoded
    @POST("orders/trial")
    Observable<Trial> getTrial(@Field("appLmt") double appLmt, @Field("productCode") String productCode, @Field("jionLifeInsurance") String jionLifeInsurance, @Field("compId") String compId, @Field("cmdtyList") JSONObject cmdtyList);

}
