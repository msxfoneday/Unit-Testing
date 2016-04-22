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
import retrofit2.http.Field;

import static org.junit.Assert.*;

/**
 * api 3.9 Testing Class
 *
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class ContractApiTest {
    private MockWebServer mockWebServer = new MockWebServer();
    ContractApi contractApi;

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

        contractApi = retrofit.create(ContractApi.class);

    }

    /**
     * Unit Testing api3.9.1
     *
     * @throws Exception
     */
    @Test
    public void test3_9_1() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        //api 3.9.1
        final URL url = mockWebServer.url("/").url();
        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        assertEquals(200, conn.getResponseCode());

    }
}