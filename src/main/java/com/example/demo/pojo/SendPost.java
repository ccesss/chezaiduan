package com.example.demo.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.SSLException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class SendPost {

    public String Post(String url, JSONObject jsonObject) throws IOException {
        JSON x=null;

        URL url1 = new URL(url);
        HttpURLConnection conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(30000);
        conne.setReadTimeout(50000);
        conne.setRequestProperty("accept","*/*");
        conne.setRequestProperty("Content-Type","application/json");
        conne.setRequestProperty("Charset","UTF-8");
        conne.setRequestProperty("connection", "close");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        //obos = DataOutputStream(conne.getOutputStream());
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        String json = JSON.toJSONString(jsonObject);
        obos.write(json.getBytes());
        obos.flush();
        obos.close();

        System.out.println(conne.getResponseCode());
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while((len = ins.read(buff)) != -1){
            baos.write(buff, 0, len);
        }
        //System.out.println(baos.getClass());
        byte[] bytes = baos.toByteArray();
        ins.close();
        String b = String.valueOf(baos);
        System.out.println(b);
        //JSONObject parse = (JSONObject) JSONArray.parse(String.valueOf(baos));

        return b;

    }
}
