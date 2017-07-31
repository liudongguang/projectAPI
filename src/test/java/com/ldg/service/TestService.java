package com.ldg.service;

import com.ldg.controller.TestBase;
import com.shiro.api.service.ShiroService;
import com.shiro.bo.UserRolePermissonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/7/31.
 */
public class TestService extends TestBase {
    @Autowired
    private ShiroService shiroService;
    @Test
    public void testService(){
        UserRolePermissonInfo urp=shiroService.selectRoleAndPermisssionByUserName("admin");
        System.out.println(urp);
    }
}
