package com.ldg.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;

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


}
