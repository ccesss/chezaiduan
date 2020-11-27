package com.example.demo.controller;

import com.example.demo.mapper.GpsMapper;
import com.example.demo.pojo.latAndLon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class GPSController {
    @Resource
    GpsMapper gpsMapper;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/gps")
    public latAndLon getGPS(){
        latAndLon gpsNow = gpsMapper.findGpsNow();
        //System.out.println("查询gps");
        return gpsNow;
    }

}
