package com.ldg.api.util;

import com.ldg.api.constant.CommConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by LiuDongguang on 2017/3/26.
 */
public class LdgRequestUtil {
    public static final Logger logger = LoggerFactory.getLogger(LdgRequestUtil.class);
    public static void soutParams(HttpServletRequest request){
        System.out.println("---------------------------------------------------------");
        Map<String,String[]> m=request.getParameterMap();
        for(String key:m.keySet()){
            System.out.println(key+"    "+m.get(key)[0]);
        }
        System.out.println("---------------------------------------------------------");
    }
    public static String getIP(HttpServletRequest request){
        String ip=request.getHeader("x-forwarded-for");
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getHeader("X-Real-IP");
        }
        if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
            ip=request.getRemoteAddr();
        }
        return ip;
    }
    public static void traverseFolder(String path,List<String> fileNames) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                       // System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder(file2.getAbsolutePath(),fileNames);
                    } else {
                        //System.out.println("文件:" + file2.getAbsolutePath());
                        fileNames.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    /**
     * @param fullFileName
     * @return
     */
    public static String getWebappFileNameByDirName(String fullFileName,String dir){
        return  fullFileName.substring(fullFileName.indexOf(dir));
    }

    /**
     * 获取项目名后的路径
     * @param request
     * @return
     */
    public static String getFilePathByWebContext(HttpServletRequest request,String url){
        String contextPath=request.getContextPath();
        return  url.substring(url.indexOf(contextPath)+contextPath.length()+1);
    }
    public static Map<String,String> getFileNameByDirName(HttpServletRequest request,String dirName){
        String indexpath=request.getServletContext().getRealPath(dirName);
        return  getFileNameByDirName(indexpath,dirName);
    }
    public static Map<String,String> getFileNameByDirName(String realPath,String dir){
        List<String> files=new ArrayList<>();
        traverseFolder(realPath,files);
        Map<String, String> rtMap = files.stream().filter(item->{
            if(item.lastIndexOf("index.jsp")!=-1){
                return false;
            }
            return true;
        }).map(item ->getWebappFileNameByDirName(item,dir)).collect(Collectors.toMap(item -> item.replaceAll("\\\\", "/"), item -> item));
        return  rtMap;
    }

}
