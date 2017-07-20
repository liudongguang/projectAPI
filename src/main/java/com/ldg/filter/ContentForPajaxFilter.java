package com.ldg.filter;

import com.ldg.api.util.*;
import com.ldg.loading.Cache_Pajax;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentForPajaxFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String reqURI = request.getRequestURI().toString();
        if (MatcherUtil.isstaticResource(reqURI)) {
            chain.doFilter(request, response);
        } else {
            //单独访问的时候替换内容,直接访问该pajax访问的页面，不是首页的时候
            if (MatcherUtil.isJSP(reqURI)) {
                String key = LdgRequestUtil.getRequestPath(reqURI);
                String val = Cache_Pajax.getPajaxFileByKey(key);
                if (val == null) {
                    chain.doFilter(request, response);
                } else {
                    handlerPajax(request, response, chain);
                }
            } else {
                String key = LdgRequestUtil.getRequestPath(reqURI);
                if (Cache_Pajax.isPajaxControllerPrex(key)) {
                    handlerPajax(request, response, chain);
                } else {
                    chain.doFilter(request, response);
                }
            }
        }
    }

    private static void handlerPajax(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String pajaxState = request.getHeader("X-PJAX");
        if (pajaxState != null) {
            chain.doFilter(request, response);
        } else {
            //是需要pajax请求的
            CoverResponse cr = new CoverResponse(response);
            chain.doFilter(request, cr);
            //处理替换
            String content = cr.getContent();
            String parentContent = RequestFileUtil.getContentByFileNameByHttpClient(request, "pajaxapimain/index.jsp");
            String rtSS = parentContent.replace("<div id=\"pajaxDIV\"></div>", content);
            response.getWriter().print(rtSS);
        }
    }
}
