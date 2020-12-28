package com.example.demo.mapper;

import com.example.demo.pojo.GoodOrder;

public interface GoodOrderMapper {
//  通过state状态查询1
    GoodOrder findByTime(String time);
//  通过state状态修改订单号
    void setOrderId(long id);

}
