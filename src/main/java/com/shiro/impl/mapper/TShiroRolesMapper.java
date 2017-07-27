package com.shiro.impl.mapper;

import com.shiro.api.po.TShiroRoles;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TShiroRolesMapper extends Mapper<TShiroRoles> {
    List<TShiroRoles> getRolePageInfo();

    Integer selectRoleNameByName(TShiroRoles param);
}