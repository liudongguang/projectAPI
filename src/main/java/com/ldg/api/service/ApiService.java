package com.ldg.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.controllerparam.GetApiInfo;

import java.util.List;

/**
 * Created by liudo on 2017/3/31.
 */
public interface ApiService {
    /**
     * 获取项目列表
     * @param pageParam
     * @return
     */
    PageInfo<TProjects> getProjectsPageInfo(PageParam pageParam);

    /**
     * 保存项目
     * @param project
     * @return
     */
    int saveProject(TProjects project);

    /**
     * 获取接口的参数信息
     * @param param
     * @return
     */
    List<TApiparams> getApiInfo(GetApiInfo param);
}
