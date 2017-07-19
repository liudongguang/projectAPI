package com.ldg.impl.mapper;

import com.ldg.api.po.TApiparams;
import com.ldg.api.po.TProjectapis;
import com.ldg.api.vo.controllerparam.GetApiInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TApiparamsMapper extends Mapper<TApiparams> {
    List<TApiparams> getApiInfo(GetApiInfo param);

    int deleteApiByProjectID(TProjectapis ele);
}