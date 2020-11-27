package com.example.demo.mapper;


import com.example.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    User findById(Long id);
    User findByUsername(String username, String password);
    List<User> findAll();
    User findID(String username);

}
