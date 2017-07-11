package com.ldg.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ldg.api.util.JsonUtil;
import com.ldg.api.vo.ResultMsg;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagerLoginInterceptor implements HandlerInterceptor {
	private  static String nologin_jsonStr;
    static {
		ResultMsg rms=new ResultMsg();
		rms.setErrcode(101);
		rms.setErrmsg("未登录！");
        try {
            nologin_jsonStr= JsonUtil.parseToJson(rms);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		Object manager = session.getAttribute("user");
		System.out.println(request.getHeader("x-requested-with"));
		if (manager != null) {
			return true;
		} else {
			if (request.getHeader("x-requested-with") != null
					&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有，x-requested-with
				response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
				response.getWriter().print(nologin_jsonStr);
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			return false;
		}
	}

}
