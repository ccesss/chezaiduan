package com.example.demo.pojo;
//state：温湿度和一个num不知道是啥

public class State {

    private String temperature;
    private String humidity;
    private String num;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }



    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
