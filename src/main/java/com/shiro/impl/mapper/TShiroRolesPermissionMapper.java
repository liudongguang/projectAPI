package com.shiro.impl.mapper;

import com.shiro.api.po.TShiroRolesPermission;
import com.shiro.vo.RoleAndPermission;
import tk.mybatis.mapper.common.Mapper;

public interface TShiroRolesPermissionMapper extends Mapper<TShiroRolesPermission> {
    int deleteByRoleID(RoleAndPermission param);
}