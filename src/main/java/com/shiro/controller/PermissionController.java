package com.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import com.shiro.api.po.TShiroPermission;
import com.shiro.api.service.ShiroService;
import com.shiro.bo.TShiroUsersExt;
import com.shiro.util.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/permission_shiro")
public class PermissionController {

   @Autowired
   private ShiroService shiroService;

    /**
     * 获取权限列表
     *
     * @return
     */
    @RequestMapping(value = "/getPermissionPageInfo")
    public String getPermissionPageInfo(HttpServletRequest request, PageParam pageParam) {
        PageInfo<TShiroPermission> permissions = shiroService.getPermissionList(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR, permissions);
        return "/pajaxapimain/permissions/permission/index.jsp";
    }

    /**
     * 保存权限
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/savePermission")
    public String savePermission(HttpServletRequest request, TShiroPermission param) {
        int i=shiroService.savePermission(param);
        return "/permission_shiro/getPermissionPageInfo";
    }

    /**
     * 权限名是否存在
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/checkPermissionName")
    @ResponseBody
    public ResultMsg checkPermissionName(HttpServletRequest request, TShiroPermission param) {
        ResultMsg rs=new ResultMsg();
        Integer id=shiroService.selectPermissionNameByName(param);
        if(id!=null){
            rs.setErrcode(1);
            rs.setErrmsg("权限名已存在");
        }
        return rs;
    }


}
