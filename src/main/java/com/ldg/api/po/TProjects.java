package com.ldg.api.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_projects")
public class TProjects {
    @Id
    private Integer uid;

    /**
     * 项目名称
     */
    private String projectname;

    /**
     * 项目描述
     */
    private String description;

    private Date createtime;

    /**
     * 服务地址
     */
    private String serverurl;

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
     * 获取项目名称
     *
     * @return projectname - 项目名称
     */
    public String getProjectname() {
        return projectname;
    }

    /**
     * 设置项目名称
     *
     * @param projectname 项目名称
     */
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    /**
     * 获取项目描述
     *
     * @return description - 项目描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置项目描述
     *
     * @param description 项目描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取服务地址
     *
     * @return serverurl - 服务地址
     */
    public String getServerurl() {
        return serverurl;
    }

    /**
     * 设置服务地址
     *
     * @param serverurl 服务地址
     */
    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }

    @Override
    public String toString() {
        return "TProjects{" +
                "uid=" + uid +
                ", projectname='" + projectname + '\'' +
                ", description='" + description + '\'' +
                ", createtime=" + createtime +
                ", serverurl='" + serverurl + '\'' +
                '}';
    }
}