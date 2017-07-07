package com.dbgenerate.api.service;

import com.dbgenerate.api.po.TDbSource;
import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;

/**
 * Created by LiuDongguang on 2017/7/7.
 */
public interface DBSourceService {
    PageInfo<TDbSource> getDbsourceList(PageParam pageParam);

    int saveSource(TDbSource param);

    TDbSource handlerDBSource(TDbSource param);

    String checkSourceNameAndlink(TDbSource param);
}
