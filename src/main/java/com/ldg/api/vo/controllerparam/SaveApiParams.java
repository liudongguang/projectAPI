package com.ldg.api.vo.controllerparam;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/4/1.
 */
public class SaveApiParams {
    private Integer apiID;
    private Integer projectid;
    private String formMethod;
    private String interfaceURL;

    private List<String> rquestParam;
    private List<String> rquestParamType;
    private List<String> rquestParamBeizhu;

    private List<String> responseParam;
    private List<String> responseParamType;
    private List<String> responseParamBeizhu;

    public Integer getApiID() {
        return apiID;
    }

    public void setApiID(Integer apiID) {
        this.apiID = apiID;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getFormMethod() {
        return formMethod;
    }

    public void setFormMethod(String formMethod) {
        this.formMethod = formMethod;
    }

    public String getInterfaceURL() {
        return interfaceURL;
    }

    public void setInterfaceURL(String interfaceURL) {
        this.interfaceURL = interfaceURL;
    }

    public List<String> getRquestParam() {
        return rquestParam;
    }

    public void setRquestParam(List<String> rquestParam) {
        this.rquestParam = rquestParam;
    }

    public List<String> getRquestParamType() {
        return rquestParamType;
    }

    public void setRquestParamType(List<String> rquestParamType) {
        this.rquestParamType = rquestParamType;
    }

    public List<String> getRquestParamBeizhu() {
        return rquestParamBeizhu;
    }

    public void setRquestParamBeizhu(List<String> rquestParamBeizhu) {
        this.rquestParamBeizhu = rquestParamBeizhu;
    }

    public List<String> getResponseParam() {
        return responseParam;
    }

    public void setResponseParam(List<String> responseParam) {
        this.responseParam = responseParam;
    }

    public List<String> getResponseParamType() {
        return responseParamType;
    }

    public void setResponseParamType(List<String> responseParamType) {
        this.responseParamType = responseParamType;
    }

    public List<String> getResponseParamBeizhu() {
        return responseParamBeizhu;
    }

    public void setResponseParamBeizhu(List<String> responseParamBeizhu) {
        this.responseParamBeizhu = responseParamBeizhu;
    }

    @Override
    public String toString() {
        return "SaveApiParams{" +
                "apiID=" + apiID +
                ", projectid=" + projectid +
                ", formMethod='" + formMethod + '\'' +
                ", interfaceURL='" + interfaceURL + '\'' +
                ", rquestParam=" + rquestParam +
                ", rquestParamType=" + rquestParamType +
                ", rquestParamBeizhu=" + rquestParamBeizhu +
                ", responseParam=" + responseParam +
                ", responseParamType=" + responseParamType +
                ", responseParamBeizhu=" + responseParamBeizhu +
                '}';
    }
}
