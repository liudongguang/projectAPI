package com.ldg.impl.mapper;

import com.ldg.api.po.TManagers;
import tk.mybatis.mapper.common.Mapper;

public interface TManagersMapper extends Mapper<TManagers> {
    TManagers selectManagerForlogin(TManagers manager);
}