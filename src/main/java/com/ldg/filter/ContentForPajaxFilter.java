package com.ldg.filter;

import com.ldg.api.util.CoverResponse;
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
        //单独访问的时候替换内容
        if (reqURL.lastIndexOf(".jsp")!=-1&&reqURL.indexOf("pajax")!=-1&& StringUtils.isBlank(head)) {
            CoverResponse cr = new CoverResponse((HttpServletResponse) response);
            fc.doFilter(request, cr);
            //处理替换
            String content = cr.getContent();
            response.getWriter().print("啦啦啦啦啦");
        }else{
            fc.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}