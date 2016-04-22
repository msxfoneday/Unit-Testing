package com.example.chuanjiang.unittest381;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowLog;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static org.junit.Assert.*;

/**
 * api3.13 Testing Class
 *
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class ProApiTest {
    private MockWebServer mockWebServer = new MockWebServer();
    ProApi proApi;

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

        proApi = retrofit.create(ProApi.class);

    }

    /**
     * Unit Testing api3.13.1
     *
     * @throws Exception
     */
    @Test
    public void test3_13_1() throws Exception {

        String proDetailJson = "{\n" +
                "    \"content\": \"123\", \n" +
                "    \"contentType\": \"123\", \n" +
                "    \"proType\": \"123\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(proDetailJson));

        //api 3.13.1
        ProDetail proDetail = proApi.getProDetail("123").toBlocking().single();
        assertEquals(new ProDetail("123", "123", "123").toString(), proDetail.toString());

    }

}