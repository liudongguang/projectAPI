package com.ldg.filter;

import com.ldg.api.util.CoverResponse;
import com.ldg.api.util.RequestFileUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentForPajaxFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String reqURL=req.getRequestURL().toString();
        String head=req.getHeader("X-PJAX");
        String replaceStr="<div id=\"pajaxDIV\"></div>";
        //单独访问的时候替换内容,直接访问该pajax访问的页面，不是首页的时候
        if (reqURL.lastIndexOf(".jsp")!=-1&&reqURL.indexOf("pajax")!=-1&& StringUtils.isBlank(head)&&reqURL.indexOf("index.jsp")==-1) {
            CoverResponse cr = new CoverResponse((HttpServletResponse) response);
            fc.doFilter(request, cr);
            //处理替换
            String content = cr.getContent();
            String parentContent= RequestFileUtil.getContentByFileName(req,"pajax/index.jsp");
            System.out.println(parentContent);
            response.getWriter().print("<html><head></head><body>jkljas;fjdls;kajf;lsa大家撒漏口风</body></html>");
        }else{
            fc.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}