package com.example.chuanjiang.unittesting38;

import android.accounts.AccountManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TestActivity01 extends AppCompatActivity {

    private Button testBtn;
    private TextView testTV;
    private HttpResponse httpResponse;
    private Handler handler;
    private String result;
    final String app_secret = "b344fd047a3929bfe2a33e61332dfdee514b7d4960d83fef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);
        testBtn = (Button) findViewById(R.id.send_btn);
        testTV = (TextView) findViewById(R.id.rp_tv);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                testTV.setText(msg.getData().getString("result"));
                System.out.println("");
                System.out.print("response");

            }
        };
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MineThread thread = new MineThread();
                thread.start();
            }
        });

    }
    public static String formatMillis(long millis, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.CHINA);
        Date date = new Date(millis);

        return dateFormat.format(date);
    }
    private int sendRequestByPost(String url){
        ArrayList<NameValuePair> headerList = new ArrayList<NameValuePair>();
        headerList.add(new BasicNameValuePair("Content-Type","application/json;charset=utf-8"));


        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try{
            ArrayList<NameValuePair> paramList = new ArrayList<NameValuePair>();
            AccountManager accountManager;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Date date = new Date();
            long diffTime = date.getTime() - System.currentTimeMillis();
            long timestamp = diffTime + System.currentTimeMillis();
          //  paramList.add(new BasicNameValuePair("mobile",""));
          //  paramList.add(new BasicNameValuePair("password",""));
            paramList.add(new BasicNameValuePair("timestamp",formatMillis(timestamp, "yyyy-MM-dd HH:mm:ss")));



            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");

            httpPost.setEntity(entity);

            httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(httpResponse.getEntity());
                analysisResponse(result);
            }
        }catch (Exception e){

        }finally {
            httpClient.getConnectionManager().shutdown();
        }

        return 0;
    }


    private void analysisResponse(String result){
        try{
            JSONObject jsonObject = new JSONObject(result);
            Bundle bundle = new Bundle();
            bundle.putString("mobile",jsonObject.getString("mobile"));
            sendResultMessage(bundle);
        }catch(Exception e){

        }
    }

    private int sendRequestByGet(String url) {
        combineGetUrl(url);

        String line;
        Bundle bundle;
        HttpGet httpGet = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        InputStream is = null;

        try {
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println("");
                System.out.print("请求成功");
            }

            is = httpResponse.getEntity().getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while (null != (line = br.readLine())) {
                result += line;
            }

            bundle = new Bundle();
            bundle.putString("result",result);
            sendResultMessage(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private int sendResultMessage(Bundle bundle){
        Message msg = new Message();
        msg.setData(bundle);
        TestActivity01.this.handler.sendMessage(msg);
        return 0;
    }

    private String combineGetUrl(String url){

        return url;
    }

    class MineThread extends Thread {
        @Override
        public void run() {
            super.run();
            sendRequestByGet("https://mapi.msxf.com/mapi/V4/user/login");

        }
    }
}

