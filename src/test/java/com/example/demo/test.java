package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.GpsMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.GoodOrder;
import com.example.demo.pojo.SendPost;
import jdk.nashorn.internal.scripts.JO;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;

public class test {
    @Resource
    private GpsMapper gpsMapper;
    @Resource
    private UserMapper userMapper;
    @Test
    public void sdf() throws IOException {
        SendPost sendPost = new SendPost();
        GoodOrder goodOrder = new GoodOrder();
        goodOrder.setCarId("1");
        goodOrder.setComplete(false);
        goodOrder.setGoodKind("猪肉");
        goodOrder.setCreateTime(LocalDateTime.now());
        goodOrder.setStarting("北京");
        String s = ("{" +
                "      \"id\": \"1020000000015\"," +
                "      \"driverId\": \"1030000000\"," +
                "      \"goodKind\": \"生猪白条\"," +
                "      \"goodName\": \"黑猪\"," +
                "      \"starting\": \"哈尔滨\"," +
                "      \"destination\": \"北京\"," +
                "      \"carId\": \"0470\"," +
                "      \"complete\": \"true\"," +
                "      \"tempHigh\": \"8\"," +
                "      \"tempLow\": \"4\"," +
                "      \"humidityHigh\": \"50\"," +
                "      \"humidityLow\": \"40\"," +
                "      \"videoHttp\": \"127.0.0.1\"," +
                "      \"delete\": \"false\"," +
//                "      \"time\": \"1\","+
//                "      \"create_time\": \"27/11/2020 18:17:55\"," +
//                "      \"update_time\": \"27/11/2020 18:17:57\"" +
                "    }");
        JSONObject jsonObject1 = JSONObject.parseObject(s);
        //System.out.println(jsonObject1);
        String post = sendPost.Post("http://localhost:8447/api/receive/completeOrder", jsonObject1);
//        System.out.println(post);
        JSONObject jsonObject = JSONObject.parseObject(post);

        System.out.println(jsonObject);



    }
    @Test
    public void ssds() throws IOException {
        SendPost sendPost = new SendPost();
        String s = "{" +
                "\"id\":1030000005}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        String post = sendPost.Post("http://localhost:8447/api/display/driver", jsonObject);
        System.out.println(post);

    }
    }

