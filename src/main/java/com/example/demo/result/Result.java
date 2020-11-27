package com.example.demo.result;

public class Result {
    //响应码
    private int code;
//    //用户id
//    private  long userID;
//
//    public long getUserID() {
//        return userID;
//    }
//
//    public Result(int code, long userID) {
//        this.code = code;
//        this.userID = userID;
//    }
//
//    public void setUserID(long userID) {
//        this.userID = userID;
//    }

    public Result(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
