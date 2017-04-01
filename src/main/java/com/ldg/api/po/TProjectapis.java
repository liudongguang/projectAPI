package com.ldg.api.po;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "TProjectapis{" +
                "uid=" + uid +
                ", parentid='" + parentid + '\'' +
                ", apititle='" + apititle + '\'' +
                ", projectid=" + projectid +
                ", level=" + level +
                '}';
    }
}