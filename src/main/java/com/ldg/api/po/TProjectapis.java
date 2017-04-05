package com.ldg.api.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_projectapis")
public class TProjectapis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    /**
     * 父id
     */
    private String parentid;

    /**
     * 接口标题
     */
    private String apititle;

    /**
     * 关联的项目id
     */
    private Integer projectid;

    /**
     * 深度
     */
    private Integer level;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 接口url
     */
    private String interfaceurl;

    /**
     * 接口描述
     */
    private String description;

    /**
     * 表单方法
     */
    private String formmethod;

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
     * 获取父id
     *
     * @return parentid - 父id
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 设置父id
     *
     * @param parentid 父id
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取接口标题
     *
     * @return apititle - 接口标题
     */
    public String getApititle() {
        return apititle;
    }

    /**
     * 设置接口标题
     *
     * @param apititle 接口标题
     */
    public void setApititle(String apititle) {
        this.apititle = apititle;
    }

    /**
     * 获取关联的项目id
     *
     * @return projectid - 关联的项目id
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * 设置关联的项目id
     *
     * @param projectid 关联的项目id
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    /**
     * 获取深度
     *
     * @return level - 深度
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置深度
     *
     * @param level 深度
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
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
     * 获取接口url
     *
     * @return interfaceurl - 接口url
     */
    public String getInterfaceurl() {
        return interfaceurl;
    }

    /**
     * 设置接口url
     *
     * @param interfaceurl 接口url
     */
    public void setInterfaceurl(String interfaceurl) {
        this.interfaceurl = interfaceurl;
    }

    /**
     * 获取接口描述
     *
     * @return description - 接口描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置接口描述
     *
     * @param description 接口描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取表单方法
     *
     * @return formmethod - 表单方法
     */
    public String getFormmethod() {
        return formmethod;
    }

    /**
     * 设置表单方法
     *
     * @param formmethod 表单方法
     */
    public void setFormmethod(String formmethod) {
        this.formmethod = formmethod;
    }

    @Override
    public String toString() {
        return "TProjectapis{" +
                "uid=" + uid +
                ", parentid='" + parentid + '\'' +
                ", apititle='" + apititle + '\'' +
                ", projectid=" + projectid +
                ", level=" + level +
                ", createtime=" + createtime +
                ", interfaceurl='" + interfaceurl + '\'' +
                ", description='" + description + '\'' +
                ", formmethod='" + formmethod + '\'' +
                '}';
    }
}