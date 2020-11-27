package com.example.demo.controller;


import com.example.demo.mapper.HumiMapper;
import com.example.demo.pojo.Demo;
import com.example.demo.pojo.State;
import com.example.demo.pojo.WebSocketUtil;
import com.example.demo.pojo.doorStateCountUtil;
import com.example.demo.result.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;

@Controller
@ServerEndpoint("/websocket/doorState")
public class DemoController{
//开关门
    @Resource
    HumiMapper humiMapper;
    int doorCount = 0;
    int i = 0;
    @CrossOrigin
    @PostMapping("api/demo")
    @ResponseBody
    public Result demo(@RequestBody Demo requestdemo){
        //doorStateCountUtil dor = new doorStateCountUtil();
        String testdata = requestdemo.getDoorState();

        System.out.println(123+testdata);

        if(Objects.equals(testdata,"open")){
            humiMapper.updateDoor("1","1");
            if (doorCount==0){
                i = doorStateCountUtil.doorStateCount();
                doorCount = 1;
            }else if(doorCount == 1){
                i = doorStateCountUtil.doorStateCount();
                doorCount = 1;
            }else if(doorCount == 2){
                doorCount = 0;
                i = doorStateCountUtil.setDoorCount(0);
            }else {
                System.out.println("计数异常");
            }


            //humiMapper.updateDoor("1","1");
        }
        else if(Objects.equals(testdata,"close")){

            humiMapper.updateDoor("1","2");
            if (doorCount==0){
                i = doorStateCountUtil.doorStateCount();
                doorCount = 2;
            }else if(doorCount == 2){
                i = doorStateCountUtil.doorStateCount();
                doorCount = 2;
            }else if(doorCount == 1){
                doorCount = 0;
                i = doorStateCountUtil.setDoorCount(0);
            }else {
                System.out.println("计数异常2");
            }
        }

        System.out.println(i);
        if(i>30){
            doorCount = 0;
            i = doorStateCountUtil.setDoorCount(0);
            //WebSocketUtil.sendMessageToAllOnlineUser("1");
            //System.out.println("刷新");
        }
        if(doorCount==0){
            WebSocketUtil.sendMessageToAllOnlineUser("1");
            System.out.println("刷新");
        }
        //WebSocketUtil.sendMessageToAllOnlineUser("1");

        return new Result(200);

    }

    private static void sendMessage(Session session, String message) {

        final RemoteEndpoint.Basic basic = session.getBasicRemote();

        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void openSession(Session session){
        //存储用户
        WebSocketUtil.USERS_ONLINE.put("username", session);

    }


    @OnClose
    public void closeSession(Session session){


        //删除用户
        WebSocketUtil.USERS_ONLINE.remove("username");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message){


    }

    @OnError
    public void sessionError(Session session, Throwable throwable){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("WebSocket连接发生异常，message:"+throwable.getMessage());
    }


}







