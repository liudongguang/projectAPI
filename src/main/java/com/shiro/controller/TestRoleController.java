package com.shiro.controller;

import com.shiro.bo.TShiroUsersExt;
import com.shiro.util.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/shirotest")
public class TestRoleController {


    @RequestMapping("/regist")
    public String regist(TShiroUsersExt user) {
        PasswordHelper phr=new PasswordHelper();
        phr.encryptPassword(user);

        return "/bootstrap4.jsp";
    }

    @RequestMapping("/login")
    public String login( String username,  String password) {
        System.out.println("--------------------------"+username+"    "+password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();
               return "/bootstrap4_1.jsp";
        }

        subject.getSession().setAttribute("user", "kkk");
        return "/bootstrap4.jsp";
    }
}
