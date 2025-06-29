package com.pan.uitils;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public final static int OK = 200;

    public final static int ERROR = 400;

    public final static int NOTAUTH = 401;

    public final static int NOTPERMISSION = 401;

    public final static int SERVRERROR = 500;


    public static String getMassage(int code, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        return JSONObject.toJSONString(map);
    }

    public static String getMassage(int code, String message, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", message);
        map.put("data", data);
        return JSONObject.toJSONString(map);
    }
}
