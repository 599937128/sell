package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @program: sell
 * @Date: 2018/9/19 21:24
 * @Author: Mr.lv
 * @Description:
 */
public class JsonUtils {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
