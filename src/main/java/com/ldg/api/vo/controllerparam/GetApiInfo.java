package com.ldg.api.vo.controllerparam;

/**
 * Created by liudo on 2017/4/1.
 */
public class GetApiInfo {
    private Integer apiID;
    private String projectid;

    public Integer getApiID() {
        return apiID;
    }

    public void setApiID(Integer apiID) {
        this.apiID = apiID;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    @Override
    public String toString() {
        return "GetApiInfo{" +
                "apiID=" + apiID +
                ", projectid='" + projectid + '\'' +
                '}';
    }
}
