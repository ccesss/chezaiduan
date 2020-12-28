package com.example.demo.controller;


import com.example.demo.mapper.*;
import com.example.demo.pojo.Driver;
import com.example.demo.pojo.FaceBase64;
import com.example.demo.pojo.GoodOrder;
import com.example.demo.pojo.User;
import com.example.demo.pojo.sensor.Humi;
import com.example.demo.pojo.sensor.Temp;
import com.example.demo.result.indexResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;

@Controller
public class indexController {

    @Resource
    DriverMapper driverMapper;
    @Resource
    GoodOrderMapper goodOrderMapper;
    @Resource
    TempMapper tempMapper;
    @Resource
    HumiMapper humiMapper;
    @Resource
    UserMapper userMapper;

    @CrossOrigin
    @PostMapping("api/indexGet")
    @ResponseBody
    //好像没有用到
    public indexResult indesInfo(@RequestBody FaceBase64 tempid){
        //传进来的是用户名
        String tempDrid = tempid.getDriverId();
        tempDrid = HtmlUtils.htmlEscape(tempDrid);

        System.out.println(tempDrid);
        //用户名和用户id的转化
        User id = userMapper.findID(tempDrid);

        Driver tempdr = driverMapper.findByNum(id.getId());

        System.out.println(tempdr.getFace_token());

        GoodOrder goodOrder = goodOrderMapper.findByTime("1");
        Temp temptp = tempMapper.findByTime("1");
        Humi temphm = humiMapper.findByTime("1");


        return new indexResult(temptp,temphm,goodOrder.getGoodKind(),tempdr);
    }


}
