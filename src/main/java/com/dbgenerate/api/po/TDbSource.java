package com.dbgenerate.api.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_db_source")
public class TDbSource {
    @Id
    private Integer uid;

    /**
     * 数据源名称
     */
    @Column(name = "dbsourceName")
    private String dbsourcename;

    /**
     * 连接地址地址
     */
    @Column(name = "dbsourceLinkurl")
    private String dbsourcelinkurl;

    /**
     * 数据源登陆名称
     */
    @Column(name = "dbsourceUsername")
    private String dbsourceusername;

    /**
     * 数据源密码
     */
    @Column(name = "dbsourcePassword")
    private String dbsourcepassword;

    /**
     * 数据源驱动
     */
    @Column(name = "dbsourceDriver")
    private String dbsourcedriver;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 数据库类型  1 mysql  2 oracle
     */
    private Integer dbtype;

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
     * 获取数据源名称
     *
     * @return dbsourceName - 数据源名称
     */
    public String getDbsourcename() {
        return dbsourcename;
    }

    /**
     * 设置数据源名称
     *
     * @param dbsourcename 数据源名称
     */
    public void setDbsourcename(String dbsourcename) {
        this.dbsourcename = dbsourcename;
    }

    /**
     * 获取连接地址地址
     *
     * @return dbsourceLinkurl - 连接地址地址
     */
    public String getDbsourcelinkurl() {
        return dbsourcelinkurl;
    }

    /**
     * 设置连接地址地址
     *
     * @param dbsourcelinkurl 连接地址地址
     */
    public void setDbsourcelinkurl(String dbsourcelinkurl) {
        this.dbsourcelinkurl = dbsourcelinkurl;
    }

    /**
     * 获取数据源登陆名称
     *
     * @return dbsourceUsername - 数据源登陆名称
     */
    public String getDbsourceusername() {
        return dbsourceusername;
    }

    /**
     * 设置数据源登陆名称
     *
     * @param dbsourceusername 数据源登陆名称
     */
    public void setDbsourceusername(String dbsourceusername) {
        this.dbsourceusername = dbsourceusername;
    }

    /**
     * 获取数据源密码
     *
     * @return dbsourcePassword - 数据源密码
     */
    public String getDbsourcepassword() {
        return dbsourcepassword;
    }

    /**
     * 设置数据源密码
     *
     * @param dbsourcepassword 数据源密码
     */
    public void setDbsourcepassword(String dbsourcepassword) {
        this.dbsourcepassword = dbsourcepassword;
    }

    /**
     * 获取数据源驱动
     *
     * @return dbsourceDriver - 数据源驱动
     */
    public String getDbsourcedriver() {
        return dbsourcedriver;
    }

    /**
     * 设置数据源驱动
     *
     * @param dbsourcedriver 数据源驱动
     */
    public void setDbsourcedriver(String dbsourcedriver) {
        this.dbsourcedriver = dbsourcedriver;
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
     * 获取数据库类型  1 mysql  2 oracle
     *
     * @return dbtype - 数据库类型  1 mysql  2 oracle
     */
    public Integer getDbtype() {
        return dbtype;
    }

    /**
     * 设置数据库类型  1 mysql  2 oracle
     *
     * @param dbtype 数据库类型  1 mysql  2 oracle
     */
    public void setDbtype(Integer dbtype) {
        this.dbtype = dbtype;
    }

    @Override
    public String toString() {
        return "TDbSource{" +
                "uid=" + uid +
                ", dbsourcename='" + dbsourcename + '\'' +
                ", dbsourcelinkurl='" + dbsourcelinkurl + '\'' +
                ", dbsourceusername='" + dbsourceusername + '\'' +
                ", dbsourcepassword='" + dbsourcepassword + '\'' +
                ", dbsourcedriver='" + dbsourcedriver + '\'' +
                ", createtime=" + createtime +
                ", dbtype=" + dbtype +
                '}';
    }
}