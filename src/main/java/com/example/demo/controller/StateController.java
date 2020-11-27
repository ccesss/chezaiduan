package com.example.demo.controller;


import com.example.demo.mapper.HumiMapper;
import com.example.demo.mapper.TempMapper;
import com.example.demo.pojo.State;
import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StateController {

    @Resource
    TempMapper tempMapper;
    @Resource
    HumiMapper humiMapper;

    @CrossOrigin
    @PostMapping("api/state")
    @ResponseBody
    public Result state(@RequestBody State stateRequest){

        String tempState = stateRequest.getTemperature();
        String humiState = stateRequest.getHumidity();
        String num = stateRequest.getNum();


        System.out.println(123+tempState+humiState+num);

        tempMapper.updateByTimeAndNum("1",stateRequest.getNum(),stateRequest.getTemperature());
        humiMapper.updateByTimeAndNum("1",stateRequest.getNum(),stateRequest.getHumidity());

        return new Result(200);
    }


}
