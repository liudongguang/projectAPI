package com.shiro.impl.mapper;

import com.shiro.api.po.TShiroUsersRoles;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TShiroUsersRolesMapper extends Mapper<TShiroUsersRoles> {
    int deleteByUserID(Integer userID);

    void batchInsertUserRoles(List<TShiroUsersRoles> rmList);
}