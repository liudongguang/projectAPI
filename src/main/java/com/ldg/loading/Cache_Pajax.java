package com.ldg.loading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LiuDongguang on 2017/7/14.
 */
public class Cache_Pajax {
    private final static Map<String, String> pajaxFiles = new ConcurrentHashMap<>();
    private final static Map<String, String> pageInfo = new ConcurrentHashMap<>();
    public static void setPajaxFiles(Map<String, String> data) {
        pajaxFiles.putAll(data);
    }

    public static String getPajaxFileByKey(String key){
        return pajaxFiles.get(key);
    }

    public static String getContentByPage(String s) {
        return pageInfo.get(s);
    }

    public static void setContentByPage(String s, String content) {
        pageInfo.put(s,content);
    }
}
