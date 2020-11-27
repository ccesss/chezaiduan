package com.example.demo.result;

import com.example.demo.pojo.Driver;
import com.example.demo.pojo.sensor.Humi;
import com.example.demo.pojo.sensor.Temp;

public class indexResult {

    int code;
    String tempA;
    String humiA;
    String kinds;
    String door;
    String name;
    String driveyear;
    String drivelv;
    String num;

    public indexResult(Temp temptp, Humi temphm, String kinds, Driver tempdr){
        Float temptpA = (Float.parseFloat(temptp.getTemp1())+
                Float.parseFloat(temptp.getTemp2())+Float.parseFloat(temptp.getTemp3())+
                Float.parseFloat(temptp.getTemp4())+Float.parseFloat(temptp.getTemp5())+
                Float.parseFloat(temptp.getTemp6())+Float.parseFloat(temptp.getTemp7()))/7;

        Float temphmA = (Float.parseFloat(temphm.getHumi1())+
                Float.parseFloat(temphm.getHumi2())+Float.parseFloat(temphm.getHumi3())+
                Float.parseFloat(temphm.getHumi4())+Float.parseFloat(temphm.getHumi5())+
                Float.parseFloat(temphm.getHumi6())+Float.parseFloat(temphm.getHumi7()))/7;

        this.tempA = temptpA.toString();
        this.humiA = temphmA.toString();

        this.door = temphm.getDoor();
        this.kinds = kinds;

        this.name = tempdr.getName();
        System.out.println(this.name);
        this.driveyear = tempdr.getDriveyear();
        this.drivelv = tempdr.getDrivelv();
        this.num = tempdr.getNum();

        this.code = 200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTempA() {
        return tempA;
    }

    public void setTempA(String tempA) {
        this.tempA = tempA;
    }

    public String getHumiA() {
        return humiA;
    }

    public void setHumiA(String humiA) {
        this.humiA = humiA;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriveyear() {
        return driveyear;
    }

    public void setDriveyear(String driveyear) {
        this.driveyear = driveyear;
    }

    public String getDrivelv() {
        return drivelv;
    }

    public void setDrivelv(String drivelv) {
        this.drivelv = drivelv;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
