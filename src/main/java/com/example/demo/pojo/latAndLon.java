package com.example.demo.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class latAndLon {

    private  String lat;
    private  String lon;
    private  String ns;
    private  String ew;
    private  int carid =1 ;
    private String v;//速度
    //private long Id;


}

