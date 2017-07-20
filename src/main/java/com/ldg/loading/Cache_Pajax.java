package com.ldg.loading;

import com.ldg.api.util.LdgRequestUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LiuDongguang on 2017/7/14.
 */
public class Cache_Pajax {
    //缓存了所有需要pajax中显示的，不能单独显示的页面
    private final static Map<String, String> pajaxFiles = new ConcurrentHashMap<>();
    //缓存的pajax主页面
    private final static Map<String, String> pageInfo = new ConcurrentHashMap<>();
    //需要pajax请求的
    private final static Map<String, String> controllerPrefix = new ConcurrentHashMap<>();
    //包含前者前缀，不需要pajax请求的路径
    private final static Map<String, String> excludecontroller = new ConcurrentHashMap<>();
    public static void addPajaxFiles(Map<String, String> data) {
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

    /////添加过滤controller前缀
    public static void addControllerPrefix(String prefix) {
        controllerPrefix.put(prefix,prefix);
    }
    /////添加过滤controller前缀
    public static void addExcludecontroller(String path) {
        excludecontroller.put(path,path);
    }

    public final static boolean isPajaxControllerPrex(String uri){
        String v=excludecontroller.get(uri);
        //是排除对象返回
        if(v!=null){
            return false;
        }
        int index=uri.indexOf("/",1);
        if(index==-1){
            return false;
        }
        v=controllerPrefix.get(uri.substring(0,index));
        //是要被pajax请求的
        if(v!=null){
            return true;
        }
        return false;
    }
}
