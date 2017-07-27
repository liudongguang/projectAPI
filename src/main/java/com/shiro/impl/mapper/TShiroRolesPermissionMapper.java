package com.shiro.impl.mapper;

import com.shiro.api.po.TShiroRolesPermission;
import com.shiro.vo.RoleAndPermission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TShiroRolesPermissionMapper extends Mapper<TShiroRolesPermission> {
    int deleteByRoleID(Integer roleID);

    void batchInsertRolePermissions(List<TShiroRolesPermission> rmList);
}