package com.shiro.bo;

import com.shiro.api.po.TShiroUsers;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
public class TShiroUsersExt extends TShiroUsers {
    public String getCredentialsSalt(){
        return this.getUsername()+this.getSalt();
    }
}
