package com.example.demo.mapper;

import com.example.demo.pojo.Order;


public interface BaseMapper {
    //增加新的订单
    public void addNewOrder(Order o);
    //找到最新一条订单信息
    public Order findLastestOrder();
    //通过订单号查找记录
    public int findByUid(long uid);
    //结束订单，标志位置0
    public void finishOrder(Order o);
    //添加或更新开始时间
    public void updateStartTime(Order o);
    //更新或添加停止时间
    public void updateStopTime(Order o);
}
