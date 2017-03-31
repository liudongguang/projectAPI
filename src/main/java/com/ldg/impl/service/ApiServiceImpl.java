package com.ldg.impl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.po.TProjects;
import com.ldg.api.service.ApiService;
import com.ldg.api.vo.PageParam;
import com.ldg.impl.mapper.TProjectsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liudo on 2017/3/31.
 */
@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private TProjectsMapper projectsDao;
    @Override
    public PageInfo<TProjects> getProjectsPageInfo(PageParam pageParam) {
        PageInfo<TProjects> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> projectsDao.selectAll());
        return pageInfo;
    }
}
