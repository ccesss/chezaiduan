package com.example.demo.controller;


import com.example.demo.mapper.DriverMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Driver;
import com.example.demo.pojo.FaceBase64;
import com.example.demo.pojo.User;
import com.example.demo.result.FaceResult;
import com.example.demo.server.FaceServer;
import com.sun.deploy.net.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;

@Controller
public class FaceController {

    @Resource
    FaceServer faceServer;
    @Resource
    DriverMapper driverMapper;
    @Resource
    UserMapper userMapper;

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/faceCom")
    public FaceResult faceppCall(@RequestBody FaceBase64 imgBase64){
        System.out.println(imgBase64.getDriverId());
        String tempBase = imgBase64.getImageBase();
        tempBase = HtmlUtils.htmlEscape(tempBase);

        String tempDrid = imgBase64.getDriverId();
        tempDrid = HtmlUtils.htmlEscape(tempDrid);
        tempDrid=userMapper.findID(tempDrid).getId();

        Driver temp = driverMapper.findByNum(tempDrid);

        int callRes = faceServer.faceppDetect(tempBase, temp.getFace_token());
        System.out.println(callRes);
        if(callRes == 1){
            return new FaceResult("刘xx", 200);
        }
        else if (callRes == 2) {
            return new FaceResult("刘xx", 401);
        }
        else{
            return new FaceResult("刘xx", 412);
        }

    }


}
