package com.shiro.impl.mapper;

import com.shiro.api.po.TShiroUsers;
import com.shiro.bo.TShiroUsersExt;
import tk.mybatis.mapper.common.Mapper;

public interface TShiroUsersMapper extends Mapper<TShiroUsers> {
    int insertUser(TShiroUsersExt user);

    TShiroUsersExt findUserByUsername(String username);
}