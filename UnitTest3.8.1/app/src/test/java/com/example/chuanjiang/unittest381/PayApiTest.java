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
 * api 3.10 Testing Class
 *
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class PayApiTest {
    private MockWebServer mockWebServer = new MockWebServer();
    PayApi payApi;

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

        payApi = retrofit.create(PayApi.class);

    }

    /**
     * Unit Testing api3.10.1
     *
     * @throws Exception
     */
    @Test
    public void test3_10_1() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        //api 3.10.1
        final URL url_3101 = mockWebServer.url("/").url();
        final HttpURLConnection conn_3101 = (HttpURLConnection) url_3101.openConnection();
        assertEquals(200, conn_3101.getResponseCode());

    }

    /**
     * Unit Testing api3.10.2
     *
     * @throws Exception
     */
    @Test
    public void test3_10_2() throws Exception {

        String checkSmsJson = "{\n" +
                "    \"smsSeqNo\": \"123456789010\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(checkSmsJson));

        //api 3.10.2
        CheckSms checkSms = payApi.getCheckSms().toBlocking().single();
        assertEquals(new CheckSms("123456789010").toString(), checkSms.toString());

    }

    /**
     * Unit Testing api3.10.3
     *
     * @throws Exception
     */
    @Test
    public void test3_10_3() throws Exception {

        String consumeJson = "{\n" +
                "    \"orderNo\": \"123456789010\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(consumeJson));

        //api 3.10.3
        Consume consume = payApi.getConsume("123456", "123456", "123456", "123456", 10L, "123456").toBlocking().single();
        assertEquals(new Consume("123456789010").toString(), consume.toString());

    }

    /**
     * Unit Testing api3.10.4
     *
     * @throws Exception
     */
    @Test
    public void test3_10_4() throws Exception {

        String paymentInfoJson = "{\n" +
                "    \"bankCardId\": 123456, \n" +
                "    \"bankCode\": \"123456\", \n" +
                "    \"bankName\": \"icbc\", \n" +
                "    \"bankCardType\": \"unknow\", \n" +
                "    \"bankCardNo\": \"123456\", \n" +
                "    \"authId\": \"123456\", \n" +
                "    \"downPmt\": 10\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(paymentInfoJson));

        //api 3.10.4
        PaymentInfo paymentInfo = payApi.getPaymentInfo("123456", "123456", "123456").toBlocking().single();
        assertEquals(new PaymentInfo(123456L, "123456", "icbc", "unknow", "123456", "123456", 10f).toString(), paymentInfo.toString());

    }

    /**
     * Unit Testing api3.10.5
     *
     * @throws Exception
     */
    @Test
    public void test3_10_5() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        //api 3.10.5
        final URL url_3105 = mockWebServer.url("/").url();
        final HttpURLConnection conn_3105 = (HttpURLConnection) url_3105.openConnection();
        assertEquals(200, conn_3105.getResponseCode());

    }

    /**
     * Unit Testing api3.10.6
     *
     * @throws Exception
     */
    @Test
    public void test3_10_6() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        //api 3.10.6
        final URL url_3106 = mockWebServer.url("/").url();
        final HttpURLConnection conn_3106 = (HttpURLConnection) url_3106.openConnection();
        assertEquals(200, conn_3106.getResponseCode());

    }

    /**
     * Unit Testing api3.10.7
     *
     * @throws Exception
     */
    @Test
    public void test3_10_7() throws Exception {

        mockWebServer.enqueue(new MockResponse().setResponseCode(200));

        //api 3.10.7
        final URL url_3107 = mockWebServer.url("/").url();
        final HttpURLConnection conn_3107 = (HttpURLConnection) url_3107.openConnection();
        assertEquals(200, conn_3107.getResponseCode());

    }

    /**
     * Unit Testing api3.10.8
     *
     * @throws Exception
     */
    @Test
    public void test3_10_8() throws Exception {

        String repayInfoJson = "{\n" +
                "    \"contractNo\": \"123456\", \n" +
                "    \"latestDueMoney\": 10, \n" +
                "    \"latestDueDate\": \"123456\", \n" +
                "    \"appLmt\": 10, \n" +
                "    \"loanTerm\": 1, \n" +
                "    \"loanCurrTerm\": \"123456\", \n" +
                "    \"loanExpireDate\":  \"123456\",\n" +
                "    \"totalOverdueMoney\": 10, \n" +
                "    \"interest\": 10\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(repayInfoJson));

        //api 3.10.8
        RepayInfo repayInfo = payApi.getRepayInfo("123", "123").toBlocking().single();
        assertEquals(new RepayInfo("123456", 10f, "123456", 10f, 1, "123456", "123456", 10f, 10f).toString(), repayInfo.toString());
    }
}