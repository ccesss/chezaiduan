package com.example.demo;

import com.example.demo.mapper.GpsMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class test {
    @Resource
    private GpsMapper gpsMapper;
    @Resource
    private UserMapper userMapper;
    @Test
    public void sdf() throws IOException {
        System.out.println(LocalDateTime.now());
    }
    }

