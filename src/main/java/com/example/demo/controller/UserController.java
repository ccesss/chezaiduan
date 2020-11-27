package com.example.demo.controller;


import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping
    public User findUser(@RequestParam(value = "id")Long id){
        return userMapper.findById(id);
    }

}
