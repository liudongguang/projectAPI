package com.shiro.impl.mapper;

import com.shiro.api.po.TShiroPermission;
import tk.mybatis.mapper.common.Mapper;

public interface TShiroPermissionMapper extends Mapper<TShiroPermission> {

    void getPermissionPageInfo();

    Integer selectPermissionNameByName(TShiroPermission param);
}