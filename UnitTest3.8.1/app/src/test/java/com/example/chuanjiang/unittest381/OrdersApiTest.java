package com.example.chuanjiang.unittest381;


import com.squareup.moshi.Json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;


/**
 * api3.8 Testing Class
 *
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class OrdersApiTest {

    private MockWebServer mockWebServer = new MockWebServer();
    OrdersApi ordersApi;

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

        ordersApi = retrofit.create(OrdersApi.class);

    }

    /**
     * Unit Testing api3.8.1
     *
     * @throws Exception
     */
    @Test
    public void test3_8_1() throws Exception {

        String payCodeJson = "{\n" +
                "    \"authType\": \"123456\", \n" +
                "    \"authId\": \"123456\", \n" +
                "    \"authCode\": \"aaaa\", \n" +
                "    \"expireDate\": \"sss\", \n" +
                "    \"downPmt\": 2000\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(payCodeJson));

        //api 3.8.1
        PayCode payCode = ordersApi.getPayCode("123", "123", "123").toBlocking().single();
        assertEquals("123456", payCode.authType);
        assertEquals("123456", payCode.authId);
        assertEquals("aaaa", payCode.authCode);
        assertEquals("sss", payCode.expireDate);
        assertEquals(String.valueOf(2000f), String.valueOf(payCode.downPmt));

    }

    /**
     * Unit Testing api3.8.2
     *
     * @throws Exception
     */
    @Test
    public void test3_8_2() throws Exception {

        String listJson = "{\n" +
                "    \"count\": 100, \n" +
                "    \"pageSize\": 10, \n" +
                "    \"pageNo\": 0, \n" +
                "    \"orderList\": [\n" +
                "        {\n" +
                "            \"inOrderId\": \"11111\", \n" +
                "            \"totalAmt\": 10, \n" +
                "            \"totalQuantity\": 11, \n" +
                "            \"orderStatus\": \"0\", \n" +
                "            \"orderTime\": 123456, \n" +
                "            \"isDownPmt\": 1, \n" +
                "            \"cmdtyList\": [\n" +
                "                {\n" +
                "                    \"catId\": \"1111\", \n" +
                "                    \"cmdtyId\": \"1111\", \n" +
                "                    \"brandName\": \"1111\", \n" +
                "                    \"cmdtyName\": \"1111\", \n" +
                "                    \"pcsCount\": 1, \n" +
                "                    \"cmdtyPrice\": 1\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(listJson));

        //api 3.8.2
        List list = ordersApi.getList("123", 1, 1).toBlocking().single();
        assertEquals(100, list.count);
        assertEquals(10, list.pageSize);
        assertEquals(0, list.pageNo);
        assertEquals("11111", list.orderList.get(0).inOrderId);
        assertEquals(String.valueOf(10f), String.valueOf(list.orderList.get(0).totalAmt));
        assertEquals(11, list.orderList.get(0).totalQuantity);
        assertEquals("0", list.orderList.get(0).orderStatus);
        assertEquals(123456, list.orderList.get(0).orderTime);
        assertEquals(1, list.orderList.get(0).isDownPmt);
        assertEquals("1111", list.orderList.get(0).cmdtyList.get(0).catId);
        assertEquals("1111", list.orderList.get(0).cmdtyList.get(0).cmdtyId);
        assertEquals("1111", list.orderList.get(0).cmdtyList.get(0).brandName);
        assertEquals("1111", list.orderList.get(0).cmdtyList.get(0).cmdtyName);
        assertEquals(1, list.orderList.get(0).cmdtyList.get(0).pcsCount);
        assertEquals(String.valueOf(1f), String.valueOf(list.orderList.get(0).cmdtyList.get(0).cmdtyPrice));

    }

    /**
     * Unit Testing api3.8.3
     *
     * @throws Exception
     */
    @Test
    public void test3_8_3() throws Exception {

        String detailJson = "{\n" +
                "    \"inOrderId\": null, \n" +
                "    \"orderStatus\": null, \n" +
                "    \"orderTime\": null, \n" +
                "    \"txnTime\": null, \n" +
                "    \"compId\": null, \n" +
                "    \"empId\": null, \n" +
                "    \"compName\": null, \n" +
                "    \"compOfficePhone \": null, \n" +
                "    \"empName\": null, \n" +
                "    \"outOrderId\": null, \n" +
                "    \"catId\": null, \n" +
                "    \"cartType\": \"goods\", \n" +
                "    \"totalAmt\": 0, \n" +
                "    \"totalQuantity\": null, \n" +
                "    \"uniqueId\": null, \n" +
                "    \"custName\": null, \n" +
                "    \"cellphone\": null, \n" +
                "    \"appId\": null, \n" +
                "    \"contractId\": null, \n" +
                "    \"crProdId\": null, \n" +
                "    \"crProdName\": null, \n" +
                "    \"curCode\": null, \n" +
                "    \"loanAmt\": null, \n" +
                "    \"loanTerm\": null, \n" +
                "    \"mthlyPmtAmt\": 0, \n" +
                "    \"isDownPmt\": 1, \n" +
                "    \"downPmtPct\": 0, \n" +
                "    \"downPmt\": 0, \n" +
                "    \"valueAddeSvc\": 1, \n" +
                "    \"cmdtyList\": [\n" +
                "        {\n" +
                "            \"catId\": null, \n" +
                "            \"cmdtyId\": null, \n" +
                "            \"brandName\": null, \n" +
                "            \"cmdtyName\": null, \n" +
                "            \"pcsCount\": null, \n" +
                "            \"cmdtyPrice\": 0\n" +
                "        }\n" +
                "    ], \n" +
                "    \"orderTravelDto\": [\n" +
                "        {\n" +
                "            \"departureTime\": null, \n" +
                "            \"returnTime\": null, \n" +
                "            \"isNeedVisa\": null, \n" +
                "            \"origin\": null, \n" +
                "            \"destination\": null, \n" +
                "            \"travelNum\": 0, \n" +
                "            \"travelKidsNum\": 0, \n" +
                "            \"travelType\": null\n" +
                "        }\n" +
                "    ], \n" +
                "    \"travelCompanDtoList\": [\n" +
                "        {\n" +
                "            \"companName\": null, \n" +
                "            \"companCellphone\": null, \n" +
                "            \"companCertId\": null, \n" +
                "            \"companRelationship\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(detailJson));

        //api 3.8.3
        Detail detail = ordersApi.getDetail("123", "123").toBlocking().single();
        java.util.List<Detail.CmdtyList> cmdtyList = new ArrayList<Detail.CmdtyList>();
        cmdtyList.add(new Detail.CmdtyList(null, null, null, null, null, 0f));
        java.util.List<Detail.OrderTravelDto> orderTravelDto = new ArrayList<Detail.OrderTravelDto>();
        orderTravelDto.add(new Detail.OrderTravelDto(null, null, null, null, null, 0, 0, null));
        java.util.List<Detail.TravelCompanDtoList> travelCompanDtoList = new ArrayList<Detail.TravelCompanDtoList>();
        travelCompanDtoList.add(new Detail.TravelCompanDtoList(null, null, null, null));
        assertEquals(new Detail(null, null, null, null, null, null, null, null, null, null, null, "goods", 0f, null, null, null, null, null, null, null, null, null, null, null, 0f, 1, 0f, 0f, 1, cmdtyList, orderTravelDto, travelCompanDtoList).toString(), detail.toString());

    }

    /**
     * Unit Testing api3.8.4
     *
     * @throws Exception
     */
    @Test
    public void test3_8_4() throws Exception {

        String shopDetailJson = "{\n" +
                "    \"cartId\": null, \n" +
                "    \"cartType\": \"goods\", \n" +
                "    \"compId\": null, \n" +
                "    \"uniqueId\": null, \n" +
                "    \"empId\": null, \n" +
                "    \"totalAmt\": null, \n" +
                "    \"totalQuantity\": \"0\", \n" +
                "    \"riskMarkCode\": null, \n" +
                "    \"cmdtyList\": [\n" +
                "        {\n" +
                "            \"catId\": null, \n" +
                "            \"cmdtyId\": null, \n" +
                "            \"brandName\": null, \n" +
                "            \"cmdtyName\": null, \n" +
                "            \"pcsCount\": \"0\", \n" +
                "            \"cmdtyPrice\": null\n" +
                "        }\n" +
                "    ], \n" +
                "    \"orderTravelDto\": [\n" +
                "        {\n" +
                "            \"departureTime\": null, \n" +
                "            \"returnTime\": null, \n" +
                "            \"isNeedVisa\": null, \n" +
                "            \"origin\": null, \n" +
                "            \"destination\": null, \n" +
                "            \"travelNum\": \"0\", \n" +
                "            \"travelKidsNum\": \"0\", \n" +
                "            \"travelType\": null\n" +
                "        }\n" +
                "    ], \n" +
                "    \"travelCompanInfoList\": [\n" +
                "        {\n" +
                "            \"companName\": null, \n" +
                "            \"companCellphone\": null, \n" +
                "            \"companCertId\": null, \n" +
                "            \"companRelationship\": null\n" +
                "        }\n" +
                "    ], \n" +
                "    \"crProdId\": null, \n" +
                "    \"isDownPmt\": \"1\", \n" +
                "    \"promId\": null, \n" +
                "    \"minDownPmt\": null, \n" +
                "    \"maxDownPmt\": null\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(shopDetailJson));

        //api 3.8.4
        ShopDetail shopDetail = ordersApi.getShopDetail("123").toBlocking().single();
        java.util.List<ShopDetail.CmdtyList> cmdtyList_sd = new ArrayList<ShopDetail.CmdtyList>();
        cmdtyList_sd.add(new ShopDetail.CmdtyList(null, null, null, null, "0", null));
        java.util.List<ShopDetail.OrderTravelDto> orderTravelDto_sd = new ArrayList<ShopDetail.OrderTravelDto>();
        orderTravelDto_sd.add(new ShopDetail.OrderTravelDto(null, null, null, null, null, "0", "0", null));
        java.util.List<ShopDetail.TravelCompanInfoList> travelCompanDtoList_sd = new ArrayList<ShopDetail.TravelCompanInfoList>();
        travelCompanDtoList_sd.add(new ShopDetail.TravelCompanInfoList(null, null, null, null));
        assertEquals(new ShopDetail(null, "goods", null, null, null, null, "0", null, cmdtyList_sd, orderTravelDto_sd, travelCompanDtoList_sd, null, "1", null, null, null).toString(), shopDetail.toString());

    }

    /**
     * Unit Testing api3.8.5
     *
     * @throws Exception
     */
    @Test
    public void test3_8_5() throws Exception {

        String createOrderJosn = "{\n" +
                "    \"appNo\": \"20150727000528\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(createOrderJosn));

        //api 3.8.5
        JSONObject orderVO = new JSONObject();
        orderVO.put("productCd", "123");
        orderVO.put("appLmt", "123");
        orderVO.put("loanTerm", "123");
        orderVO.put("jionLifeInsurance", "123");
        orderVO.put("lifeInsuranceAmt", "123");
        orderVO.put("loanFixedAmt", "123");
        orderVO.put("downPmtScale", "123");
        orderVO.put("downOmtAmt", "123");
        orderVO.put("totalAmt", "123");
        orderVO.put("isDownPmt", "1");
        orderVO.put("promId", "123");

        JSONObject accessoryInfoVO = new JSONObject();
        accessoryInfoVO.put("fileId", "123");
        accessoryInfoVO.put("accessoryType", "123");
        accessoryInfoVO.put("name", "123");

        JSONObject cartVO = new JSONObject();
        cartVO.put("cartId", "123");
        cartVO.put("cartType", "goods");
        cartVO.put("compId", "123");
        cartVO.put("empId", "123");
        cartVO.put("totalAmt", "123");
        cartVO.put("totalQuantity", 0);
        cartVO.put("riskMarkCode", "123");
        JSONArray cmdtyList = new JSONArray();
        JSONObject catId = new JSONObject();
        JSONObject cmdtyId = new JSONObject();
        JSONObject brandName = new JSONObject();
        JSONObject cmdtyName = new JSONObject();
        JSONObject pcsCount = new JSONObject();
        JSONObject cmdtyPrice = new JSONObject();
        catId.put("catId", "123");
        cmdtyId.put("cmdtyId", "123");
        brandName.put("brandName", "123");
        cmdtyName.put("cmdtyName", "123");
        pcsCount.put("pcsCount", 0);
        cmdtyPrice.put("cmdtyPrice", "123");
        cmdtyList.put(0, catId);
        cmdtyList.put(1, cmdtyId);
        cmdtyList.put(2, brandName);
        cmdtyList.put(3, cmdtyName);
        cmdtyList.put(4, pcsCount);
        cmdtyList.put(5, cmdtyPrice);
        cartVO.put("cmdtyList", cmdtyList);
        JSONArray orderTravelDto = new JSONArray();
        JSONObject departureTime = new JSONObject();
        JSONObject returnTime = new JSONObject();
        JSONObject isNeedVisa = new JSONObject();
        JSONObject origin = new JSONObject();
        JSONObject destination = new JSONObject();
        JSONObject travelNum = new JSONObject();
        JSONObject travelKidsNum = new JSONObject();
        JSONObject travelType = new JSONObject();
        departureTime.put("departureTime", "123");
        returnTime.put("returnTime", "123");
        isNeedVisa.put("isNeedVisa", "123");
        origin.put("origin", "123");
        destination.put("destination", "123");
        travelNum.put("travelNum", 0);
        travelKidsNum.put("travelKidsNum", 0);
        travelType.put("travelType", "123");
        orderTravelDto.put(0, departureTime);
        orderTravelDto.put(1, returnTime);
        orderTravelDto.put(2, isNeedVisa);
        orderTravelDto.put(3, origin);
        orderTravelDto.put(4, destination);
        orderTravelDto.put(5, travelNum);
        orderTravelDto.put(6, travelKidsNum);
        orderTravelDto.put(7, travelType);
        cartVO.put("orderTravelDto", orderTravelDto);
        JSONArray travelCompanInfoList = new JSONArray();
        JSONObject companName = new JSONObject();
        JSONObject companCellphone = new JSONObject();
        JSONObject companCertId = new JSONObject();
        JSONObject companRelationship = new JSONObject();
        companName.put("companName", "123");
        companCellphone.put("companCellphone", "123");
        companCertId.put("companCertId", "123");
        companRelationship.put("companRelationship", "123");
        travelCompanInfoList.put(0, companName);
        travelCompanInfoList.put(1, companCellphone);
        travelCompanInfoList.put(2, isNeedVisa);
        travelCompanInfoList.put(3, companRelationship);
        cartVO.put("orderTravelDto", orderTravelDto);
        cartVO.put("crProdId", "123");
        cartVO.put("promId", "123");
        cartVO.put("minDownPmt", "123");
        cartVO.put("maxDownPmt", "123");
        cartVO.put("internalCode", "123");

        CreateOrder createOrder = ordersApi.getCreateOrder("1", orderVO, accessoryInfoVO, cartVO).toBlocking().single();
        assertEquals("20150727000528", createOrder.appNo);

    }

    /**
     * Unit Testing api3.8.6
     *
     * @throws Exception
     */
    @Test
    public void test3_8_6() throws Exception {

        String trialJson = "{\n" +
                "    \"loanFixedAmt\": \"1900.00\", \n" +
                "    \"lifeInsuranceAmt\": \"0.00\", \n" +
                "    \"promId\": \"12345678\"\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(trialJson));

        //api 3.8.6
        JSONObject trialInputJson = new JSONObject();

        trialInputJson.put("catId", "123");
        trialInputJson.put("cmdtyId", "123");
        trialInputJson.put("brandName", "123");
        trialInputJson.put("cmdtyName", "123");
        trialInputJson.put("pcsCount", 0);
        trialInputJson.put("cmdtyPrice", "123");

        Trial trial = ordersApi.getTrial(10f, "123", "123", "123", trialInputJson).toBlocking().single();
        assertEquals(new Trial("1900.00", "0.00", "12345678").toString(), trial.toString());
    }
}
