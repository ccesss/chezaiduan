package com.example.demo.result;

public class FaceResult {

    String driverId;
    int code;

    public FaceResult(String id, int code){
        this.driverId = id;
        this.code = code;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
