package com.shiro.impl.service;

import com.shiro.api.service.ShiroService;
import com.shiro.bo.TShiroUsersExt;
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
}
