package com.ldg.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_managers")
public class TManagers {
    @Id
    private Integer uid;

    /**
     * 登陆名
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 姓名
     */
    private String uname;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 权限
     */
    private Integer authority;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取登陆名
     *
     * @return username - 登陆名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登陆名
     *
     * @param username 登陆名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登陆密码
     *
     * @return password - 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登陆密码
     *
     * @param password 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取姓名
     *
     * @return uname - 姓名
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置姓名
     *
     * @param uname 姓名
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取权限
     *
     * @return authority - 权限
     */
    public Integer getAuthority() {
        return authority;
    }

    /**
     * 设置权限
     *
     * @param authority 权限
     */
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}