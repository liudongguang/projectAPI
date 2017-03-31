package com.ldg.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/apiHandler")
public class APIController {
    public final static Logger logger = LoggerFactory.getLogger(APIController.class);
    @Autowired
    private ApiService apiSV;

    /**
     * 登陆操作
     * @param request
     * @return
     */

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        return "/apimain/index.jsp";
    }
    /**
     * 获取项目列表
     * @return
     */
    @RequestMapping(value = "/getProjects")
    public String getProjects(HttpServletRequest request, PageParam pageParam) {
        PageInfo<TProjects> projects=apiSV.getProjectsPageInfo(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR,projects);
        return "/apimain/project/disProjectList.jsp";
    }

    /**
     * 保存项目项
     * @param request
     * @param project
     * @return
     */
    @RequestMapping(value = "/saveProject")
    public String saveProject(HttpServletRequest request,TProjects project) {
        int saveState=apiSV.saveProject(project);
        return "/apiHandler/getProjects";
    }
}
