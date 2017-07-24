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
import java.util.Arrays;
import java.util.Map;

public class SysInitialize implements ServletContextAware {
    @Override
    public void setServletContext(ServletContext servletContext) {
        /////1.需要pajax请求的页面
        String dirName= PropertiesUtil.getValByKey(CommConstant.pajaxdirName);//此文件夹下都需要pajax请求
        Arrays.asList(dirName.split(CommConstant.symbol_comma)).forEach(item->{
            String realPath=servletContext.getRealPath(item);
            Map<String,String> pajaxFile=LdgRequestUtil.getFileNameByDirName(realPath,item);
            Cache_Pajax.addPajaxFiles(pajaxFile);
        });
        /////////////
        ////需要pajax请求的controller前缀
        String controllerPrefix= PropertiesUtil.getValByKey(CommConstant.pajaxControllerPrefixr);//此文件夹下都需要pajax请求
        Arrays.asList(controllerPrefix.split(CommConstant.symbol_comma)).forEach(item->{
            Cache_Pajax.addControllerPrefix(item);
        });
        ////
        ////排除过滤的controller路径
        String excludecontroller= PropertiesUtil.getValByKey(CommConstant.excludePajaxControllerPath);//此文件夹下都需要pajax请求
        Arrays.asList(excludecontroller.split(CommConstant.symbol_comma)).forEach(item->{
            Cache_Pajax.addExcludecontroller(item);
        });
        ////

    }
}