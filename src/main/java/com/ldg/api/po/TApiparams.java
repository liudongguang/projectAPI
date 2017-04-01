package com.ldg.api.po;

import javax.persistence.*;

@Table(name = "t_apiparams")
public class TApiparams {
    @Id
    private Integer uid;

    /**
     * 项目id
     */
    private Integer projectid;

    /**
     * 接口id
     */
    private Integer apiid;

    /**
     * 1 输入参数  2输出参数
     */
    private Integer ptype;

    /**
     * 参数名称
     */
    private String paramname;

    /**
     * 参数类型
     */
    private String paramtype;

    private String parambeizhu;

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
     * 获取项目id
     *
     * @return projectid - 项目id
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * 设置项目id
     *
     * @param projectid 项目id
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    /**
     * 获取接口id
     *
     * @return apiid - 接口id
     */
    public Integer getApiid() {
        return apiid;
    }

    /**
     * 设置接口id
     *
     * @param apiid 接口id
     */
    public void setApiid(Integer apiid) {
        this.apiid = apiid;
    }

    /**
     * 获取1 输入参数  2输出参数
     *
     * @return ptype - 1 输入参数  2输出参数
     */
    public Integer getPtype() {
        return ptype;
    }

    /**
     * 设置1 输入参数  2输出参数
     *
     * @param ptype 1 输入参数  2输出参数
     */
    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    /**
     * 获取参数名称
     *
     * @return paramname - 参数名称
     */
    public String getParamname() {
        return paramname;
    }

    /**
     * 设置参数名称
     *
     * @param paramname 参数名称
     */
    public void setParamname(String paramname) {
        this.paramname = paramname;
    }

    /**
     * 获取参数类型
     *
     * @return paramtype - 参数类型
     */
    public String getParamtype() {
        return paramtype;
    }

    /**
     * 设置参数类型
     *
     * @param paramtype 参数类型
     */
    public void setParamtype(String paramtype) {
        this.paramtype = paramtype;
    }

    /**
     * @return parambeizhu
     */
    public String getParambeizhu() {
        return parambeizhu;
    }

    /**
     * @param parambeizhu
     */
    public void setParambeizhu(String parambeizhu) {
        this.parambeizhu = parambeizhu;
    }
}