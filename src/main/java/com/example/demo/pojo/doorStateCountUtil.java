package com.example.demo.pojo;

import java.util.HashMap;
import java.util.Map;

public class doorStateCountUtil {
    private static Map<String, Integer> map = null;
    private static int doorCount= 0;
    static {
        map = new HashMap<String, Integer>();
    }


    /**
     *
     * 实现一个简单的计数器
     * @param str
     * @return
     */
    public static int countNum(String str) {
        if (!(str==null)) {
            Integer count = map.get(str);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(str, count);
        }
        return map.get(str);
    }
    public static int clearMap(){
        map.clear();
        return 0;
    }
    public static int doorStateCount(){
        doorCount++;
        return doorCount;
    }
    public static int setDoorCount(int i){
        doorCount = i;
        return i;
    }
}
