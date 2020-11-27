package com.example.demo.controller;


import com.example.demo.mapper.GoodMapper;
import com.example.demo.mapper.KindthMapper;
import com.example.demo.pojo.Good;
import com.example.demo.pojo.Kindth;
import com.example.demo.result.GoodResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class GoodController {

    @Resource
    GoodMapper goodMapper;
    @Resource
    KindthMapper kindthMapper;


    @CrossOrigin
    @ResponseBody
    @PostMapping("api/goodGet")
    public GoodResult good(){

        Good tempGood = goodMapper.findByTime("1");
        Kindth tempKindth = kindthMapper.findByKinds(tempGood.getKinds());

        return new GoodResult(tempGood,tempKindth);
    }

}
