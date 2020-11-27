package com.example.demo.result;

import com.example.demo.pojo.sensor.Humi;
import com.example.demo.pojo.sensor.Temp;

public class boxResult {

    private int code;

    String Humi1,Humi2,Humi3,Humi4,Humi5,Humi6,Humi7,Door;

    public String getDoor() {
        return Door;
    }

    public void setDoor(String door) {
        Door = door;
    }

    String Temp1,Temp2,Temp3,Temp4,Temp5,Temp6,Temp7;

    public boxResult(int code, Humi humires, Temp tempres){
        this.code = code;

        this.Humi1=humires.getHumi1();
        this.Humi2=humires.getHumi2();
        this.Humi3=humires.getHumi3();
        this.Humi4=humires.getHumi4();
        this.Humi5=humires.getHumi5();
        this.Humi6=humires.getHumi6();
        this.Humi7=humires.getHumi7();
        this.Door=humires.getDoor();

        this.Temp1=tempres.getTemp1();
        this.Temp2=tempres.getTemp2();
        this.Temp3=tempres.getTemp3();
        this.Temp4=tempres.getTemp4();
        this.Temp5=tempres.getTemp5();
        this.Temp6=tempres.getTemp6();
        this.Temp7=tempres.getTemp7();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHumi1() {
        return Humi1;
    }

    public void setHumi1(String humi1) {
        Humi1 = humi1;
    }

    public String getHumi2() {
        return Humi2;
    }

    public void setHumi2(String humi2) {
        Humi2 = humi2;
    }

    public String getHumi3() {
        return Humi3;
    }

    public void setHumi3(String humi3) {
        Humi3 = humi3;
    }

    public String getHumi4() {
        return Humi4;
    }

    public void setHumi4(String humi4) {
        Humi4 = humi4;
    }

    public String getHumi5() {
        return Humi5;
    }

    public void setHumi5(String humi5) {
        Humi5 = humi5;
    }

    public String getHumi6() {
        return Humi6;
    }

    public void setHumi6(String humi6) {
        Humi6 = humi6;
    }

    public String getHumi7() {
        return Humi7;
    }

    public void setHumi7(String humi7) {
        Humi7 = humi7;
    }

    public String getTemp1() {
        return Temp1;
    }

    public void setTemp1(String temp1) {
        Temp1 = temp1;
    }

    public String getTemp2() {
        return Temp2;
    }

    public void setTemp2(String temp2) {
        Temp2 = temp2;
    }

    public String getTemp3() {
        return Temp3;
    }

    public void setTemp3(String temp3) {
        Temp3 = temp3;
    }

    public String getTemp4() {
        return Temp4;
    }

    public void setTemp4(String temp4) {
        Temp4 = temp4;
    }

    public String getTemp5() {
        return Temp5;
    }

    public void setTemp5(String temp5) {
        Temp5 = temp5;
    }

    public String getTemp6() {
        return Temp6;
    }

    public void setTemp6(String temp6) {
        Temp6 = temp6;
    }

    public String getTemp7() {
        return Temp7;
    }

    public void setTemp7(String temp7) {
        Temp7 = temp7;
    }
}
