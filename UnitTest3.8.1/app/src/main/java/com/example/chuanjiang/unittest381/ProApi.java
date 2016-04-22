package com.example.chuanjiang.unittest381;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public interface ProApi {
    @GET("pro/detail")
    Observable<ProDetail> getProDetail(@Query("type") String type);
}
