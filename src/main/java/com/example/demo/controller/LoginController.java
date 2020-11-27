package com.example.demo.controller;

import com.example.demo.mapper.BaseMapper;
import com.example.demo.mapper.GpsMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.ParamConfig;
import com.example.demo.pojo.SerialPortUtils;
import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class LoginController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private BaseMapper baseMapper;

    //跨域注解
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){

        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        System.out.println("前端请求过来的用户名和密码："+requestUser);
        User resUser = userMapper.findByUsername(username,requestUser.getPassword());
        //System.out.println(resUser);
        if(userMapper.findID(username)==null){
            String message = "账号不存在";
            System.out.println("test");
            return new Result(417);
        }
        if(resUser==null){
            String message = "账号或密码错误";
            System.out.println("账号或密码错误");
            return new Result(400);
        }
        System.out.println(resUser);
        if(Objects.equals(username,resUser.getUsername())&&Objects.equals(requestUser.getPassword(),resUser.getPassword())){
            //密码正确时调起串口
//            ParamConfig com6 = new ParamConfig("COM6", 9600, 0, 8, 1);
//            SerialPortUtils serialPortUtils = new SerialPortUtils();
//            try {
//                serialPortUtils.init(com6);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            //生成新的订单id
            System.out.println("进入密码正确判断");
            System.out.println(baseMapper.findLastestOrder());
            Order lastestOrder = baseMapper.findLastestOrder();
            System.out.println("uid---->"+lastestOrder.getUid());
            int uid = baseMapper.findByUid(lastestOrder.getUid());
            if(uid==1){
                System.out.println("当前有订单正在执行");
                //return new Result(2001);
            }else {
                Order order = new Order();
                order.setUid(lastestOrder.getUid()+1);
                order.setCarid("1");
                LocalDateTime now = LocalDateTime.now();
                order.setCreateTime(now.plusHours(8L));
                baseMapper.addNewOrder(order);
            }

            return new Result(200);
        }
        else {
            String message = "账号密码错误";
            System.out.println("回一个400");
            return new Result(400);
        }

    }
    //退出登录操作
    @CrossOrigin
    @PostMapping(value = "api/logout")
    @ResponseBody
    public Result logout(){
        //退出操作
        Order lastestOrder = baseMapper.findLastestOrder();
        lastestOrder.setCurrentOrder(0);
        baseMapper.finishOrder(lastestOrder);
        return new Result(200);
    }
}
