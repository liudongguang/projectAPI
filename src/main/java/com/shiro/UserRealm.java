package com.shiro;

import com.shiro.api.service.ShiroService;
import com.shiro.bo.TShiroUsersExt;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;

    /**
     *授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("AuthorizationInfo++++++++++++++++++++++++++");
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<String> roleNames = new HashSet<String>();
        roleNames.add("admin");
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限
        Set<String> permissionNames = new HashSet<String>();
        permissionNames.add("add");

        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionNames);
        return authorizationInfo;
    }

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("AuthenticationInfo............");
        String username = (String) token.getPrincipal();
        TShiroUsersExt user = shiroService.findUserByUsername(username);
        System.out.println(user);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,
                user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
        return authenticationInfo;
    }
}