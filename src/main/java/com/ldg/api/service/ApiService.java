package com.ldg.api.service;

import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.jstree.JsTreeData;

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
     * 获取接口信息
     * @return
     */
    List<TProjectapis> getApiTitlesData(Integer projectid);

    /**
     * 保存根节点
     * @param projectid
     * @return
     */
    int saveRootMenu(Integer projectid);

    /**
     * 保存树数据信息
     * @param saveData
     * @return
     */
    int saveApiTitleData(List<JsTreeData> saveData);
}
