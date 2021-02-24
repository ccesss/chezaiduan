package com.example.demo.controller;


import com.example.demo.mapper.GoodOrderMapper;
import com.example.demo.pojo.GoodOrder;
import com.example.demo.result.GoodResult;
import com.example.demo.result.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class GoodOrderController {

    @Resource
    GoodOrderMapper goodOrderMapper;


    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/goodGet")
    public HttpResult<GoodOrder> good(){
        GoodOrder goodOrder = goodOrderMapper.findByTime("1");
        return HttpResult.of(goodOrder);
    }

}
