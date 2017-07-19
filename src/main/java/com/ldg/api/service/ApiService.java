package com.ldg.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TManagers;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.controllerparam.GetApiInfo;
import com.ldg.api.vo.controllerparam.SaveApiParams;

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
    List<TApiparams> getApiParamInfo(GetApiInfo param);

    /**
     * 保存参数
     * @param param
     * @return
     */
    int saveApiParams(SaveApiParams param);

    /**
     * 获取接口信息
     * @param param
     * @return
     */
    TProjectapis getApiInfo(GetApiInfo param);

    /**
     * 管理员登陆
     * @param manager
     * @return
     */
    TManagers login(TManagers manager);

    /**
     * 根据项目名查询id
     * @param project
     * @return
     */
    Integer selectProjectIDByName(TProjects project);

    /**
     * 通过id删除项目
     * @param ele
     * @return
     */
    int delApiProjectByID(TProjectapis ele);
}
