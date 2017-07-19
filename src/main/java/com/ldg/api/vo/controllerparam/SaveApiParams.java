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

    private List<Integer> requestParamUID;//参数id   新增的参数id为-1
    private List<String> requestParam;//请求参数名
    private List<String> requestParamType;//请求参数类型
    private List<String> requestParamrequired;//1.必填  2.不必填
    private List<String> requestParamBeizhu;//请求参数备注
    private List<Integer> requestDelParamUID;//删除的参数id

    private List<Integer> responseParamUID;//参数id   新增的参数id为-1
    private List<String> responseParam;//返回参数名
    private List<String> responseParamType;//返回参数类型
    private List<String> responseParamrequired;//1.必填  2.不必填
    private List<String> responseParamBeizhu;//返回参数备注
    private List<Integer> responseDelParamUID;//删除的参数id


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getRequestParamUID() {
        return requestParamUID;
    }

    public void setRequestParamUID(List<Integer> requestParamUID) {
        this.requestParamUID = requestParamUID;
    }

    public List<String> getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(List<String> requestParam) {
        this.requestParam = requestParam;
    }

    public List<String> getRequestParamType() {
        return requestParamType;
    }

    public void setRequestParamType(List<String> requestParamType) {
        this.requestParamType = requestParamType;
    }

    public List<String> getRequestParamrequired() {
        return requestParamrequired;
    }

    public void setRequestParamrequired(List<String> requestParamrequired) {
        this.requestParamrequired = requestParamrequired;
    }

    public List<String> getRequestParamBeizhu() {
        return requestParamBeizhu;
    }

    public void setRequestParamBeizhu(List<String> requestParamBeizhu) {
        this.requestParamBeizhu = requestParamBeizhu;
    }

    public List<Integer> getRequestDelParamUID() {
        return requestDelParamUID;
    }

    public void setRequestDelParamUID(List<Integer> requestDelParamUID) {
        this.requestDelParamUID = requestDelParamUID;
    }

    public List<Integer> getResponseParamUID() {
        return responseParamUID;
    }

    public void setResponseParamUID(List<Integer> responseParamUID) {
        this.responseParamUID = responseParamUID;
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

    public List<String> getResponseParamrequired() {
        return responseParamrequired;
    }

    public void setResponseParamrequired(List<String> responseParamrequired) {
        this.responseParamrequired = responseParamrequired;
    }

    public List<String> getResponseParamBeizhu() {
        return responseParamBeizhu;
    }

    public void setResponseParamBeizhu(List<String> responseParamBeizhu) {
        this.responseParamBeizhu = responseParamBeizhu;
    }

    public List<Integer> getResponseDelParamUID() {
        return responseDelParamUID;
    }

    public void setResponseDelParamUID(List<Integer> responseDelParamUID) {
        this.responseDelParamUID = responseDelParamUID;
    }

    @Override
    public String toString() {
        return "SaveApiParams{" +
                "apiID=" + apiID +
                ", projectid=" + projectid +
                ", formMethod='" + formMethod + '\'' +
                ", interfaceURL='" + interfaceURL + '\'' +
                ", description='" + description + '\'' +
                ", requestParamUID=" + requestParamUID +
                ", requestParam=" + requestParam +
                ", requestParamType=" + requestParamType +
                ", requestParamrequired=" + requestParamrequired +
                ", requestParamBeizhu=" + requestParamBeizhu +
                ", requestDelParamUID=" + requestDelParamUID +
                ", responseParamUID=" + responseParamUID +
                ", responseParam=" + responseParam +
                ", responseParamType=" + responseParamType +
                ", responseParamrequired=" + responseParamrequired +
                ", responseParamBeizhu=" + responseParamBeizhu +
                ", responseDelParamUID=" + responseDelParamUID +
                '}';
    }
}
