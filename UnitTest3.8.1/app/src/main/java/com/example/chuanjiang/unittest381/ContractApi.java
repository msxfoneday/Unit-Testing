package com.example.chuanjiang.unittest381;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public interface ContractApi {
    @FormUrlEncoded
    @POST("contract/confirm")
    Observable<Confirm> getConfirm(@Field("appNo") String appNo);

}
