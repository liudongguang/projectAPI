package com.shiro.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.shiro.api.po.TShiroPermission;
import com.shiro.api.po.TShiroRoles;
import com.shiro.api.po.TShiroRolesPermission;
import com.shiro.api.service.ShiroService;
import com.shiro.bo.TShiroUsersExt;
import com.shiro.impl.mapper.TShiroPermissionMapper;
import com.shiro.impl.mapper.TShiroRolesMapper;
import com.shiro.impl.mapper.TShiroRolesPermissionMapper;
import com.shiro.impl.mapper.TShiroUsersMapper;
import com.shiro.util.PasswordHelper;
import com.shiro.vo.RoleAndPermission;
import com.shiro.vo.RoleAndPermissionList;
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
          int delNum=roleAndPermissionDao.deleteByRoleID(param);
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
}
