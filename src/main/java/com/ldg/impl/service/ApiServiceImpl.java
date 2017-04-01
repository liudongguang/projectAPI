package com.ldg.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import com.ldg.api.vo.controllerparam.GetApiInfo;
import com.ldg.impl.mapper.TApiparamsMapper;
import com.ldg.impl.mapper.TProjectapisMapper;
import com.ldg.impl.mapper.TProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by liudo on 2017/3/31.
 */
@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private TProjectapisMapper projectapisDao;

    @Autowired
    private TProjectsMapper projectsDao;
    @Autowired
    private TApiparamsMapper tApiparamsDao;
    @Override
    public PageInfo<TProjects> getProjectsPageInfo(PageParam pageParam) {
        PageInfo<TProjects> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> projectsDao.getProjectsPageInfo());
        return pageInfo;
    }

    @Override
    public int saveProject(TProjects project) {
        project.setCreatetime(new Date());
        return projectsDao.insertSelective(project);
    }

    @Override
    public List<TApiparams> getApiInfo(GetApiInfo param) {
        return tApiparamsDao.getApiInfo(param);
    }
}
