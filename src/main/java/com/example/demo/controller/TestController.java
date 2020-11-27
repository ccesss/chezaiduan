package com.example.demo.controller;

import com.example.demo.mapper.DriverMapper;
import com.example.demo.server.FaceServer;
import com.example.demo.server.GetFaceTokenServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
//尝试获取facetoken，失败
@Controller
public class TestController {

    @CrossOrigin
    @ResponseBody
    @PostMapping("api/Test")
    public void TestFaceDetect(){
        GetFaceTokenServer getFaceTokenServer = new GetFaceTokenServer();
        getFaceTokenServer.faceppDetect();
    }

}
