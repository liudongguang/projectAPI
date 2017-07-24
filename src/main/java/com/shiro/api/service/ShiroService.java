package com.shiro.api.service;

import com.shiro.bo.TShiroUsersExt;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
public interface ShiroService {
    int addUser(TShiroUsersExt user);

    TShiroUsersExt findUserByUsername(String username);
}
