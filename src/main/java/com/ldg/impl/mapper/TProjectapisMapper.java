package com.ldg.impl.mapper;

import com.ldg.api.po.TProjectapis;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TProjectapisMapper extends Mapper<TProjectapis> {
    List<TProjectapis> getApiTitlesDataByProjectId(Integer projectid);
}