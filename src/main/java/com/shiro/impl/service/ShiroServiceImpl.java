package com.shiro.impl.service;

import com.shiro.api.service.ShiroService;
import com.shiro.impl.mapper.TShiroUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private TShiroUsersMapper shiroUserDao;


}
