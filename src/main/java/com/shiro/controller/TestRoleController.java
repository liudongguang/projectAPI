package com.shiro.controller;

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

/**
 * Created by LiuDongguang on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/shirotest")
public class TestRoleController {

   @Autowired
   private ShiroService shiroService;

    @RequestMapping("/regist")
    public String regist(TShiroUsersExt user) {
        int i=shiroService.addUser(user);
        return "/bootstrap4.jsp";
    }

    @RequestMapping("/login")
    public String login( TShiroUsersExt user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            //token.setRememberMe(true);
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            return "/error.jsp";
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            return "/error.jsp";
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            return "/error.jsp";
        }
        System.out.println(subject.isPermittedAll("add"));
        System.out.println(subject.hasRole("admin"));
        subject.getSession().setAttribute("user", "kkk");
        return "/bootstrap4.jsp";
    }
}
