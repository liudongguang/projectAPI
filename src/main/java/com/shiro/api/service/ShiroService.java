package com.shiro.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;
import com.shiro.api.po.TShiroPermission;
import com.shiro.bo.TShiroUsersExt;

/**
 * Created by LiuDongguang on 2017/7/24.
 */
public interface ShiroService {
    /**
     * 增加用户
     * @param user
     * @return
     */
    int addUser(TShiroUsersExt user);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    TShiroUsersExt findUserByUsername(String username);

    /**
     * 获取权限列表
     * @param pageParam
     * @return
     */
    PageInfo<TShiroPermission> getPermissionList(PageParam pageParam);

    /**
     * 保存权限
     * @param param
     * @return
     */
    int savePermission(TShiroPermission param);

    /**
     * 查询权限名是否存在
     * @param param
     * @return
     */
    Integer selectPermissionNameByName(TShiroPermission param);

    /**
     * 删除权限
     * @param param
     * @return
     */
    int deletePermission(TShiroPermission param);
}
