package com.ldg.impl.mapper;

import com.ldg.api.po.TProjectapis;
import com.ldg.api.po.TProjects;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TProjectapisMapper extends Mapper<TProjectapis> {
    List<TProjectapis> getApiTitlesDataByProjectId(Integer projectid);

    String getTitleNameForsaveTreeHandler(Integer uid);

    Integer updateTitleNameByPrimaryKey(TProjectapis pp);

    int deleteApiByProjectID(TProjectapis ele);
}