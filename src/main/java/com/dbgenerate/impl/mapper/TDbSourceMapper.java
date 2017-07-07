package com.dbgenerate.impl.mapper;

import com.dbgenerate.api.po.TDbSource;
import tk.mybatis.mapper.common.Mapper;

public interface TDbSourceMapper extends Mapper<TDbSource> {
    Integer selectUIDBySourceName(TDbSource param);

    Integer selectUIDBySourceLink(TDbSource param);
}