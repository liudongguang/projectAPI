package com.ldg.impl.mapper;

import com.ldg.api.po.TProjects;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TProjectsMapper extends Mapper<TProjects> {
    List<TProjects> getProjectsPageInfo();


    Integer selectProjectIDByName(TProjects project);
}