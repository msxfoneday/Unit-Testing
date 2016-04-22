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
 * api3.12 Testing Class
 *
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class AdvApiTest {
    private MockWebServer mockWebServer = new MockWebServer();
    AdvApi advApi;

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

        advApi = retrofit.create(AdvApi.class);

    }

    /**
     * Unit Testing api3.12.1
     *
     * @throws Exception
     */
    @Test
    public void test3_12_1() throws Exception {

        String advListJson = "{\n" +
                "    \"type\": \"123\", \n" +
                "    \"priority\": 0, \n" +
                "    \"content\": \"123\", \n" +
                "    \"filePath\": \"123\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(advListJson));

        //api 3.12.1
        AdvList advList = advApi.getAdvList("123").toBlocking().single();
        assertEquals(new AdvList("123", 0, "123", "123").toString(), advList.toString());

    }


}