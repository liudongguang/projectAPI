package com.ldg.api.vo.controllerparam;

/**
 * Created by liudo on 2017/4/1.
 */
public class InitApiTitleData {
    private Integer projectid;
    private String projectname;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    @Override
    public String toString() {
        return "InitApiTitleData{" +
                "projectid=" + projectid +
                ", projectname='" + projectname + '\'' +
                '}';
    }
}
