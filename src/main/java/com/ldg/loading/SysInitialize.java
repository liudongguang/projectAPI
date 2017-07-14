package com.ldg.loading;

import com.ldg.api.util.LdgRequestUtil;
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
        String dirName="pajax";
        String realPath=servletContext.getRealPath(dirName);
        Map<String,String> pajaxFile=LdgRequestUtil.getFileNameByDirName(realPath,dirName);
        Cache_Pajax.setPajaxFiles(pajaxFile);
    }
}