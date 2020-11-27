package com.example.demo.mapper;

import com.example.demo.pojo.sensor.Humi;

import java.util.List;

public interface HumiMapper {
    Humi findByTime(String time);
    List<Humi> findAll();
    int updateDoor(String time,String door);
    int updateByTimeAndNum(String time, String num, String humi);
}
