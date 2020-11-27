package com.example.demo.result;

import com.example.demo.pojo.Good;
import com.example.demo.pojo.Kindth;

public class GoodResult {

    String kinds;
    String pweight;
    String tempd, tempu;
    String humid, humiu;
    String loadtime;
    String startpls, destpls;

    int code;

    public GoodResult(Good good, Kindth kindth){
        this.kinds = good.getKinds();
        this.pweight = good.getPweight();
        this.tempd = kindth.getTempd();
        this.tempu = kindth.getTempu();
        this.humid = kindth.getHumid();
        this.humiu = kindth.getHumiu();

        this.loadtime = good.getLoadtime();
        this.startpls = good.getStartpls();
        this.destpls = good.getDestpls();

        this.code = 200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getPweight() {
        return pweight;
    }

    public void setPweight(String pweight) {
        this.pweight = pweight;
    }

    public String getTempd() {
        return tempd;
    }

    public void setTempd(String tempd) {
        this.tempd = tempd;
    }

    public String getTempu() {
        return tempu;
    }

    public void setTempu(String tempu) {
        this.tempu = tempu;
    }

    public String getHumid() {
        return humid;
    }

    public void setHumid(String humid) {
        this.humid = humid;
    }

    public String getHumiu() {
        return humiu;
    }

    public void setHumiu(String humiu) {
        this.humiu = humiu;
    }

    public String getLoadtime() {
        return loadtime;
    }

    public void setLoadtime(String loadtime) {
        this.loadtime = loadtime;
    }

    public String getStartpls() {
        return startpls;
    }

    public void setStartpls(String startpls) {
        this.startpls = startpls;
    }

    public String getDestpls() {
        return destpls;
    }

    public void setDestpls(String destpls) {
        this.destpls = destpls;
    }
}
