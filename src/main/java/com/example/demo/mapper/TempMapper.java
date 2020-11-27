package com.example.demo.mapper;


import com.example.demo.pojo.sensor.Temp;

import java.util.List;

public interface TempMapper {

    Temp findByTime(String time);
    List<Temp> findAll();
    int updateByTimeAndNum(String time, String num, String temp);

}
