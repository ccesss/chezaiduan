package com.example.demo.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.BaseMapper;

import com.example.demo.mapper.GpsMapper;
import com.example.demo.mapper.HumiMapper;
import com.example.demo.mapper.TempMapper;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.SendPost;
import com.example.demo.pojo.latAndLon;
import com.example.demo.pojo.sensor.Humi;
import com.example.demo.pojo.sensor.Temp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.json.Json;
import javax.net.ssl.SSLException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

//定时任务
@Service
public class ScheduledService {
    @Resource
    private GpsMapper gpsMapper;
    @Resource
    private BaseMapper baseMapper;
    @Resource
    private HumiMapper humiMapper;
    @Resource
    private TempMapper tempMapper;

    //每分钟发送车辆状态数据
    @Scheduled(cron = "0 * * * * 0-7")
    public void sendIno(){
        System.out.println("向服务器发送信息"+ LocalDateTime.now());
        latAndLon gpsNow = gpsMapper.findGpsNow();
        System.out.println(gpsNow);
        Order order = baseMapper.findLastestOrder();
        Temp temp = tempMapper.findByTime("1");
        Humi humi = humiMapper.findByTime("1");


        SendPost sendPost = new SendPost();
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(gpsNow);
            System.out.println(jsonObject);
            //订单号
            jsonObject.put("orderId",order.getUid());
            //温湿度状态
            jsonObject.put("humidity1",humi.getHumi1());
            jsonObject.put("humidity2",humi.getHumi2());
            jsonObject.put("humidity3",humi.getHumi3());
            jsonObject.put("humidity4",humi.getHumi4());
            jsonObject.put("humidity5",humi.getHumi5());
            jsonObject.put("humidity6",humi.getHumi6());
            jsonObject.put("humidity7",humi.getHumi7());
            jsonObject.put("temperature1",temp.getTemp1());
            jsonObject.put("temperature2",temp.getTemp2());
            jsonObject.put("temperature3",temp.getTemp3());
            jsonObject.put("temperature4",temp.getTemp4());
            jsonObject.put("temperature5",temp.getTemp5());
            jsonObject.put("temperature6",temp.getTemp6());
            jsonObject.put("temperature7",temp.getTemp7());
            //车门状态
            jsonObject.put("doorState",Integer.valueOf(humi.getDoor()));
            //经纬度
            jsonObject.put("longitude",gpsNow.getLon());
            jsonObject.put("latitude",gpsNow.getLat());
            jsonObject.put("longitudeState",1);
            jsonObject.put("latitudeState",1);
            //报警状态
            jsonObject.put("alert",0);

            sendPost.Post("http://localhost:8447/api/receive/carState", jsonObject);
            //System.out.println(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(gpsNow.toString());
    }


    @Bean
    @Nullable
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolScheduler = new ThreadPoolTaskScheduler();
        threadPoolScheduler.setThreadNamePrefix("SockJS-");
        threadPoolScheduler.setPoolSize(Runtime.getRuntime().availableProcessors());
        threadPoolScheduler.setRemoveOnCancelPolicy(true);
        return threadPoolScheduler;
    }



    //发送post请求



}
