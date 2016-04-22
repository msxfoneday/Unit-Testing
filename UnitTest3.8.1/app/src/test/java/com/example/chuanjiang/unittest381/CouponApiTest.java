package com.example.chuanjiang.unittest381;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowLog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static org.junit.Assert.*;

/**
 * api3.11 Testing Class
 *
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class CouponApiTest {
    private MockWebServer mockWebServer = new MockWebServer();
    CouponApi couponApi;

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    @Before
    public void setUp() throws IOException {
        ShadowLog.stream = System.out;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create()).build();

        couponApi = retrofit.create(CouponApi.class);

    }

    /**
     * Unit Testing api3.11.1
     *
     * @throws Exception
     */
    @Test
    public void test3_11_1() throws Exception {

        String couponsListJson = "{\n" +
                "    \"id\": \"123\", \n" +
                "    \"ticketRuleId\": 10, \n" +
                "    \"ticketName\": \"123\", \n" +
                "    \"type\": \"123\", \n" +
                "    \"phone\": \"123\", \n" +
                "    \"receiveTime\": \"123\", \n" +
                "    \"receiveChannel\": \"123\", \n" +
                "    \"effectDateBegin\": \"123\", \n" +
                "    \"effectDate\": \"123\", \n" +
                "    \"status\": \"1\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(couponsListJson));

        //api 3.11.1
        CouponsList couponsList = couponApi.getCouponList("123").toBlocking().single();
        assertEquals(new CouponsList("123", 10l, "123", "123", "123", "123", "123", "123", "123", "1").toString(), couponsList.toString());

    }

    /**
     * Unit Testing api3.11.2
     *
     * @throws Exception
     */
    @Test
    public void test3_11_2() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        //api 3.11.1
        final URL url_3112 = mockWebServer.url("/").url();
        final HttpURLConnection conn_3107 = (HttpURLConnection) url_3112.openConnection();
        assertEquals(200, conn_3107.getResponseCode());

    }
}