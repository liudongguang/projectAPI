package com.ldg.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TManagers;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.controllerparam.GetApiInfo;
import com.ldg.api.vo.controllerparam.SaveApiParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/apiHandler2")
public class APIController2 {
    public final static Logger logger = LoggerFactory.getLogger(APIController2.class);
    @Autowired
    private ApiService apiService;


    /**
     * 登陆操作
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, TManagers manager) {
        TManagers selectManager = apiService.login(manager);
        if (selectManager != null) {
            request.getSession().setAttribute("user", selectManager);
            return "redirect:/pajaxapimain/index.jsp";
        } else {
            request.setAttribute("message", "用户名或密码错误！");
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest request, TManagers manager) {
        request.getSession().invalidate();
        return "redirect:/index.jsp";
    }

    /**
     * 获取项目列表
     *
     * @return
     */
    @RequestMapping(value = "/getProjects")
    public String getProjects(HttpServletRequest request, PageParam pageParam) {
        PageInfo<TProjects> projects = apiService.getProjectsPageInfo(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR, projects);
        return "/pajaxapimain/project/disProjectList.jsp";
    }


    /**
     * 保存项目项
     *
     * @param request
     * @param project
     * @return
     */
    @RequestMapping(value = "/saveProject")
    public String saveProject(HttpServletRequest request, TProjects project) {
        int saveState = apiService.saveProject(project);
        System.out.println("插入条数"+saveState);
        return "/apiHandler2/getProjects";
    }

    /**
     * 获取api的详细信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getApiInfo")
    public String getApiInfo(HttpServletRequest request, GetApiInfo param) {
        List<TApiparams> paramlist = apiService.getApiParamInfo(param);
        ////分组按照参数类型
        Map<Integer, List<TApiparams>> typeMap = paramlist.stream().collect(Collectors.groupingBy(TApiparams::getPtype));
        request.setAttribute("paramListRquest", typeMap.get(1));
        request.setAttribute("paramListResponse", typeMap.get(2));
        /////////
        TProjectapis objapi = apiService.getApiInfo(param);
        request.setAttribute("apiobj", objapi);
        TManagers sessionManager= (TManagers) request.getSession().getAttribute("user");
        if(sessionManager.getAuthority()==2){
            return "/pajaxapimain/projectapilock/apidetails.jsp";
        }
        return "/pajaxapimain/projectapi/addapi.jsp";
    }

    /**
     * 保存参数信息
     *
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/saveApiParams")
    public String saveApiParams(HttpServletRequest request, SaveApiParams param) {
        int saveNum = apiService.saveApiParams(param);
        return "/apiHandler2/getApiInfo";
    }

}