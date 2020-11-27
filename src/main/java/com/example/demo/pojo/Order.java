package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//订单的base表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long uid;//订单号
    private String carid;//车辆编号
    private LocalDateTime createTime;//订单创建时间
    private int currentOrder;//当前订单是否进行中的标志位
    private LocalDateTime startTime;//开车时间
    private LocalDateTime stopTime;//停车时间
}
