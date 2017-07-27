package com.shiro.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.shiro.api.po.*;
import com.shiro.api.service.ShiroService;
import com.shiro.bo.TShiroUsersExt;
import com.shiro.impl.mapper.*;
import com.shiro.util.PasswordHelper;
import com.shiro.vo.RoleAndPermission;
import com.shiro.vo.RoleAndPermissionList;
import com.shiro.vo.UserAndRole;
import com.shiro.vo.UserAndRoleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private TShiroUsersMapper shiroUserDao;
    @Autowired
    private TShiroPermissionMapper permissionDao;
    @Autowired
    private TShiroRolesMapper roleDao;
    @Autowired
    private TShiroRolesPermissionMapper roleAndPermissionDao;
    @Autowired
    private TShiroUsersRolesMapper usersRoleDao;
    @Override
    public int addUser(TShiroUsersExt user) {
        PasswordHelper phr = new PasswordHelper();
        phr.encryptPassword(user); //密码处理
        user.setCreatetime(new Date());
        return shiroUserDao.insertUser(user);
    }

    @Override
    public TShiroUsersExt findUserByUsername(String username) {
        return shiroUserDao.findUserByUsername(username);
    }

    @Override
    public PageInfo<TShiroPermission> getPermissionPageInfo(PageParam pageParam) {
        PageInfo<TShiroPermission> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> permissionDao.getPermissionPageInfo());
        return pageInfo;
    }

    @Override
    public int savePermission(TShiroPermission param) {
        return permissionDao.insertSelective(param);
    }

    @Override
    public Integer selectPermissionNameByName(TShiroPermission param) {
        return permissionDao.selectPermissionNameByName(param);
    }

    @Override
    public int deletePermission(TShiroPermission param) {
        return permissionDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public PageInfo<TShiroRoles> getRolePageInfo(PageParam pageParam) {
        PageInfo<TShiroRoles> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> roleDao.getRolePageInfo());
        return pageInfo;
    }

    @Override
    public int saveRole(TShiroRoles param) {
        return roleDao.insertSelective(param);
    }

    @Override
    public Integer selectRoleNameByName(TShiroRoles param) {
        return roleDao.selectRoleNameByName(param);
    }

    @Override
    public int deleteRole(TShiroRoles param) {
        roleAndPermissionDao.deleteByRoleID(param.getUid());
        return roleDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public List<TShiroPermission> getPermissionList() {
        return permissionDao.getPermissionPageInfo();
    }

    @Override
    public void saveRoleAndPermission(RoleAndPermission param) {
        String permisseions=param.getPermissionIDS();
        if(permisseions!=null&&permisseions.length()!=0){
          int delNum=roleAndPermissionDao.deleteByRoleID(param.getRoleID());
            List<TShiroRolesPermission>  rmList= Arrays.asList(param.getPermissionIDS().split(",")).stream().map(item -> {
                TShiroRolesPermission rm = new TShiroRolesPermission();
                rm.setRoleid(param.getRoleID());
                rm.setPermissionid(Integer.valueOf(item));
                return rm;
            }).collect(Collectors.toList());
            roleAndPermissionDao.batchInsertRolePermissions(rmList);
        }
    }

    @Override
    public PageInfo<RoleAndPermissionList> getRoleAndPermissionPageInfo(PageParam pageParam) {
        PageInfo<RoleAndPermissionList> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> roleDao.getRoleAndPermissionPageInfo());
        return pageInfo;
    }
//////////////////////////////////////
    @Override
    public PageInfo<UserAndRoleList> getUserAndRolePageInfo(PageParam pageParam) {
        PageInfo<UserAndRoleList> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> shiroUserDao.getUserAndRolePageInfo());
        return pageInfo;
    }

    @Override
    public int saveUser(TShiroUsers param) {
        return shiroUserDao.insertSelective(param);
    }

    @Override
    public Integer selectUserNameByName(TShiroUsers param) {
        return shiroUserDao.selectUserNameByName(param);
    }

    @Override
    public int deleteUser(TShiroUsers param) {
        return shiroUserDao.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public List<TShiroRoles> getRoleList() {
        return roleDao.getRolePageInfo();
    }

    @Override
    public int saveUserAndRole(UserAndRole param) {
        String roleids=param.getRoleIDS();
        if(roleids!=null&&roleids.length()!=0){
            int delNum=usersRoleDao.deleteByUserID(param.getUserID());
            List<TShiroUsersRoles>  rmList= Arrays.asList(param.getRoleIDS().split(",")).stream().map(item -> {
                TShiroUsersRoles rm = new TShiroUsersRoles();
                rm.setRoleid(Integer.valueOf(item));
                rm.setUserid(param.getUserID());
                return rm;
            }).collect(Collectors.toList());
            usersRoleDao.batchInsertUserRoles(rmList);
        }
        return 0;
    }
}
