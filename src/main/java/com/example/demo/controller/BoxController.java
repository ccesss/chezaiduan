package com.example.demo.controller;


import com.example.demo.mapper.HumiMapper;
import com.example.demo.mapper.TempMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Demo;
import com.example.demo.pojo.sensor.Humi;
import com.example.demo.pojo.sensor.Temp;
import com.example.demo.result.Result;
import com.example.demo.result.boxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class BoxController {

    @Resource
    private HumiMapper humiMapper;
    @Resource
    private TempMapper tempMapper;


    @CrossOrigin
    @PostMapping("api/boxGet")
    @ResponseBody
    public boxResult boxinfo(){

        Humi resHumi = humiMapper.findByTime("1");
        Temp resTemp = tempMapper.findByTime("1");


        return new boxResult(200,resHumi,resTemp);

    }
}
