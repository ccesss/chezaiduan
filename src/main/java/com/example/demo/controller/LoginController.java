package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.BaseMapper;
import com.example.demo.mapper.GoodOrderMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.*;
import com.example.demo.result.Result;
import com.example.demo.server.FaceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class LoginController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private BaseMapper baseMapper;
    @Resource
    private FaceServer faceServer;
    @Resource
    private GoodOrderMapper goodOrderMapper;

    //跨域注解
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody FaceBase64 faceBase64){
        //登录操作
        SendPost sendPost = new SendPost();
        String reqDriverId = faceBase64.getDriverId();
        reqDriverId = HtmlUtils.htmlEscape(reqDriverId);
        HashMap<String, String> driverListMap = new HashMap<>();
        GoodOrder goodOrder = goodOrderMapper.findByTime("1");
        String s = ("{" +
//                "      \"id\": \"1020000000000\"," +
                "      \"driverId\": \"1030000000\"," +
                "      \"goodKind\": \"生猪白条\"," +
                "      \"goodName\": \"黑猪\"," +
                "      \"starting\": \"哈尔滨\"," +
                "      \"destination\": \"北京\"," +
                "      \"carId\": \"0470\"," +
                "      \"complete\": \"false\"," +
                "      \"tempHigh\": \"8\"," +
                "      \"tempLow\": \"4\"," +
                "      \"humidityHigh\": \"50\"," +
                "      \"humidityLow\": \"40\"," +
                "      \"videoHttp\": \"127.0.0.1\"," +
                "      \"delete\": \"false\"," +
//                "      \"create_time\": \"27/11/2020 18:17:55\"," +
//                "      \"update_time\": \"27/11/2020 18:17:57\"" +
                "    }");
        JSONObject jsonObject1 = JSONObject.parseObject(String.valueOf(goodOrder));
        try {
            String post = sendPost.Post("http://localhost:8447/api/send/driverList", null);
            System.out.println(post);
            JSONObject jsonObject = JSON.parseObject(post);
            JSONArray driverList = jsonObject.getJSONArray("data");
            for (int i = 0; i < driverList.size(); i++) {
                String id = (String) driverList.getJSONObject(i).get("id");
                String faceToken = (String) driverList.getJSONObject(i).get("faceToken");
                driverListMap.put(id,faceToken);
            }
        } catch (IOException e) {
            System.out.println("post发送有问题");
        }
        System.out.println(driverListMap);
        if(driverListMap.containsKey(reqDriverId)){
            int callRes = faceServer.faceppDetect(HtmlUtils.htmlEscape(faceBase64.getImageBase()), driverListMap.get(reqDriverId));
            if(callRes == 1){
                try {
                    String post = sendPost.Post("http://localhost:8447/api/receive/goodOrder",
                            jsonObject1);
                    JSONObject jsonObject = JSONObject.parseObject(post);
                    Long  data = (Long) jsonObject.get("data");
                    goodOrderMapper.setOrderId(data);

                } catch (IOException e) {
                    System.out.println("发送商品订单信息失败");
                }
                return new Result(200);//成功
            }
            else if (callRes == 2) {
                return new Result( 401);//未检测到人脸
            }
            else{
                return new Result(412);//人脸检测失败
            }

        }else return new Result(400);//司机编号不正确





    }
    //退出登录操作
    @CrossOrigin
    @PostMapping(value = "api/logout")
    @ResponseBody
    public Result logout(){
        //退出操作
        Order lastestOrder = baseMapper.findLastestOrder();
        lastestOrder.setCurrentOrder(0);
        baseMapper.finishOrder(lastestOrder);
        return new Result(200);
    }
}
