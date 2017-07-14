package com.ldg.loading;

import com.ldg.api.constant.CommConstant;
import com.ldg.api.util.LdgRequestUtil;
import com.ldg.api.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class SysInitialize implements ServletContextAware {
    @Override
    public void setServletContext(ServletContext servletContext) {
        String dirName= PropertiesUtil.getValByKey(CommConstant.pajaxdirName);//此文件夹下都需要pajax请求
        String realPath=servletContext.getRealPath(dirName);
        Map<String,String> pajaxFile=LdgRequestUtil.getFileNameByDirName(realPath,dirName);
        Cache_Pajax.setPajaxFiles(pajaxFile);
    }
}