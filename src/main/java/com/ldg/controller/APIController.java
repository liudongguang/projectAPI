package com.ldg.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TManagers;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import com.ldg.api.vo.controllerparam.GetApiInfo;
import com.ldg.api.vo.controllerparam.SaveApiParams;
import com.shiro.api.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liudo on 2017/3/10 0010.
 */
@Controller
@RequestMapping(value = "/apiHandler")
public class APIController {
    public final static Logger logger = LoggerFactory.getLogger(APIController.class);
    @Autowired
    private ApiService apiService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 登陆操作
     *
     * @param request
     * @return
     */

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, TManagers manager) {
        UsernamePasswordToken token = new UsernamePasswordToken(manager.getUsername(), manager.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            //token.setRememberMe(true);
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            request.setAttribute("message", "密码错误！");
            return "/index.jsp";
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            request.setAttribute("message", "未知的用户名！");
            return "/index.jsp";
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            request.setAttribute("message", "登录次数过多！");
            return "/index.jsp";
        }catch (LockedAccountException eae) {
            // 捕获错误登录过多的异常
            request.setAttribute("message", "帐户锁定！");
            return "/index.jsp";
        }
        request.getSession().setAttribute("user",shiroService.findUserByUsername(manager.getUsername()));
        return "redirect:/pajaxapimain/index.jsp";
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut() {
        SecurityUtils.getSubject().logout();
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
     * 删除项目
     * @param request
     * @param ele
     * @return
     */
    @RequestMapping(value = "/delApiProject")
    public String delApiProject(HttpServletRequest request,TProjectapis ele) {
        int i=apiService.delApiProjectByID(ele);
        return "/apiHandler/getProjects";
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
        return "/apiHandler/getProjects";
    }

    @RequestMapping(value = "/checkProjectName")
    @ResponseBody
    public ResultMsg checkProjectName(HttpServletRequest request, TProjects project) {
        ResultMsg rs=new ResultMsg();
        Integer id=apiService.selectProjectIDByName(project);
        if(id!=null){
            rs.setErrcode(1);
            rs.setErrmsg("项目名称已存在");
        }
        return rs;
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

        if(SecurityUtils.getSubject().isPermitted("apivisitor")){
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
        return "/apiHandler/getApiInfo";
    }

}
