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
    private String description;//接口描述

    private List<Integer> rquestParamUID;//参数id   新增的参数id为-1
    private List<String> rquestParam;//请求参数名
    private List<String> rquestParamType;//请求参数类型
    private List<String> rquestParamrequired;//1.必填  2.不必填
    private List<String> rquestParamBeizhu;//请求参数备注
    private List<Integer> rquestDelParamUID;//删除的参数id

    private List<Integer> responseParamUID;//参数id   新增的参数id为-1
    private List<String> responseParam;//返回参数名
    private List<String> responseParamType;//返回参数类型
    private List<String> responseParamrequired;//1.必填  2.不必填
    private List<String> responseParamBeizhu;//返回参数备注
    private List<Integer> responseDelParamUID;//删除的参数id


    public List<String> getRquestParamrequired() {
        return rquestParamrequired;
    }

    public void setRquestParamrequired(List<String> rquestParamrequired) {
        this.rquestParamrequired = rquestParamrequired;
    }

    public List<String> getResponseParamrequired() {
        return responseParamrequired;
    }

    public void setResponseParamrequired(List<String> responseParamrequired) {
        this.responseParamrequired = responseParamrequired;
    }

    public List<Integer> getRquestDelParamUID() {
        return rquestDelParamUID;
    }

    public void setRquestDelParamUID(List<Integer> rquestDelParamUID) {
        this.rquestDelParamUID = rquestDelParamUID;
    }

    public List<Integer> getResponseDelParamUID() {
        return responseDelParamUID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResponseDelParamUID(List<Integer> responseDelParamUID) {
        this.responseDelParamUID = responseDelParamUID;
    }

    public List<Integer> getRquestParamUID() {
        return rquestParamUID;
    }

    public void setRquestParamUID(List<Integer> rquestParamUID) {
        this.rquestParamUID = rquestParamUID;
    }

    public List<Integer> getResponseParamUID() {
        return responseParamUID;
    }

    public void setResponseParamUID(List<Integer> responseParamUID) {
        this.responseParamUID = responseParamUID;
    }

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
                ", rquestParamUID=" + rquestParamUID +
                ", rquestParam=" + rquestParam +
                ", rquestParamType=" + rquestParamType +
                ", rquestParamBeizhu=" + rquestParamBeizhu +
                ", rquestDelParamUID=" + rquestDelParamUID +
                ", responseParamUID=" + responseParamUID +
                ", responseParam=" + responseParam +
                ", responseParamType=" + responseParamType +
                ", responseParamBeizhu=" + responseParamBeizhu +
                ", responseDelParamUID=" + responseDelParamUID +
                '}';
    }
}
