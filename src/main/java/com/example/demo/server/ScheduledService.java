package com.example.demo.server;

import com.example.demo.mapper.BaseMapper;
import com.example.demo.mapper.GpsMapper;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.latAndLon;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//定时任务
@Service public class ScheduledService {
    @Resource
    private GpsMapper gpsMapper;
    @Resource
    private BaseMapper baseMapper;

    //特定时间
    @Scheduled(cron = "0 * * * * 0-7")
    public void sendIno(){
        System.out.println("向服务器发送信息"+ LocalDateTime.now());
        latAndLon gpsNow = gpsMapper.findGpsNow();
        Order order = baseMapper.findLastestOrder();
        String strV = gpsNow.getV();
        double v = Double.valueOf(strV);

        if(v>20){
            if(order.getStartTime()==null) {
                order.setStartTime(LocalDateTime.now().plusHours(8L));
                //baseMapper.updateStartTime(order);
            }

        }
        System.out.println(gpsNow);
        //sendPost("http://localhost:8447/api/accept/gps","有没有消息啊");
        System.out.println(gpsNow.toString());
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
