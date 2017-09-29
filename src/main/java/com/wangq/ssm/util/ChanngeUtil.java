package com.wangq.ssm.util;

import com.alibaba.fastjson.JSONObject;

public class ChanngeUtil {

    private static JSONObject jsonObject=new JSONObject();
    private static String msg="success";

    public static Object toJson(Integer code,Object obj){
        jsonObject.put("code",String.valueOf(code));
        jsonObject.put("msg",msg);
        jsonObject.put("data",obj);
        return jsonObject;
    }

    public static Object toJson(Object obj){
        jsonObject.put("code","200");
        jsonObject.put("msg",msg);
        jsonObject.put("data",obj);
        return jsonObject;
    }
}
