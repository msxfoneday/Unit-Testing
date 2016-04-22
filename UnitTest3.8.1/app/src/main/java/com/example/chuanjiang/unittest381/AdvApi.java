package com.example.chuanjiang.unittest381;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public interface AdvApi {

    @GET("adv/list")
    Observable<AdvList> getAdvList(@Query("type") String type);

}
