package com.shiro.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.shiro.api.po.TShiroPermission;
import com.shiro.api.service.ShiroService;
import com.shiro.bo.TShiroUsersExt;
import com.shiro.impl.mapper.TShiroPermissionMapper;
import com.shiro.impl.mapper.TShiroUsersMapper;
import com.shiro.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private TShiroUsersMapper shiroUserDao;
    @Autowired
    private TShiroPermissionMapper permissionDao;
    @Override
    public int addUser(TShiroUsersExt user) {
        PasswordHelper phr=new PasswordHelper();
        phr.encryptPassword(user); //密码处理
        user.setCreatetime(new Date());
        return shiroUserDao.insertUser(user);
    }

    @Override
    public TShiroUsersExt findUserByUsername(String username) {
        return shiroUserDao.findUserByUsername(username);
    }

    @Override
    public PageInfo<TShiroPermission> getPermissionList(PageParam pageParam) {
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
}
