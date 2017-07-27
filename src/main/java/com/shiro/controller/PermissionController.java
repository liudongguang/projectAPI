package com.shiro.controller;

import com.github.pagehelper.PageInfo;
import com.ldg.api.constant.CommConstant;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.ResultMsg;
import com.shiro.api.po.TShiroPermission;
import com.shiro.api.po.TShiroRoles;
import com.shiro.api.service.ShiroService;
import com.shiro.vo.RoleAndPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        PageInfo<TShiroPermission> permissions = shiroService.getPermissionPageInfo(pageParam);
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


    /**
     * 删除权限
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/deletePermission")
    public String deletePermission(HttpServletRequest request, TShiroPermission param) {
        int i=shiroService.deletePermission(param);
        return "/permission_shiro/getPermissionPageInfo";
    }
    /*******************角色*************************/
    /**
     * 获取角色列表
     *
     * @return
     */
    @RequestMapping(value = "/getRolePageInfo")
    public String getRolePageInfo(HttpServletRequest request, PageParam pageParam) {
        PageInfo<TShiroRoles> permissions = shiroService.getRolePageInfo(pageParam);
        request.setAttribute(CommConstant.PAGE_REQUEST_ATTR, permissions);
        return "/pajaxapimain/permissions/role/index.jsp";
    }

    /**
     * 保存角色
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/saveRole")
    public String saveRole(HttpServletRequest request, TShiroRoles param) {
        int i=shiroService.saveRole(param);
        return "/permission_shiro/getRolePageInfo";
    }

    /**
     * 角色名是否存在
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/checkRoleName")
    @ResponseBody
    public ResultMsg checkRoleName(HttpServletRequest request, TShiroRoles param) {
        ResultMsg rs=new ResultMsg();
        Integer id=shiroService.selectRoleNameByName(param);
        if(id!=null){
            rs.setErrcode(1);
            rs.setErrmsg("角色名已存在");
        }
        return rs;
    }


    /**
     * 删除角色
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/deleteRole")
    public String deleteRole(HttpServletRequest request, TShiroRoles param) {
        int i=shiroService.deleteRole(param);
        return "/permission_shiro/getRolePageInfo";
    }

    /**
     * 打开分配权限页面
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/distributionPermission")
    public String distributionPermission(HttpServletRequest request, TShiroRoles param) {

        return "/pajaxapimain/permissions/role/distribution_permission.jsp";
    }

    @RequestMapping(value = "/getPermissionList")
    @ResponseBody
    public List<TShiroPermission> getPermissionList(HttpServletRequest request, TShiroRoles param) {
        return shiroService.getPermissionList();
    }

    /**
     * 保存角色与其权限
     * @param request
     * @param param
     * @return
     */
    @RequestMapping(value = "/saveRoleAndPermission")
    public String saveRoleAndPermission(HttpServletRequest request, RoleAndPermission param) {
        shiroService.saveRoleAndPermission(param);
        return "/permission_shiro/getRolePageInfo";
    }

}
