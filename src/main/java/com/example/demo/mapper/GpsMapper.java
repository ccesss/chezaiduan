package com.example.demo.mapper;

import com.example.demo.pojo.latAndLon;

public interface GpsMapper {
    latAndLon findGpsNow();
    int updateGps(int carid,String ew, String ns, String lat, String lon, String v);
    //int updateGps(latAndLon l);
}
