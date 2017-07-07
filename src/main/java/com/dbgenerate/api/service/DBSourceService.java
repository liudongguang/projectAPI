package com.dbgenerate.api.service;

import com.dbgenerate.api.bo.LdgTable;
import com.dbgenerate.api.bo.LdgTableInfo;
import com.dbgenerate.api.po.TDbSource;
import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;

import java.util.List;

/**
 * Created by LiuDongguang on 2017/7/7.
 */
public interface DBSourceService {
    PageInfo<TDbSource> getDbsourceList(PageParam pageParam);

    int saveSource(TDbSource param);

    List<LdgTable> getTables(TDbSource param) throws Exception;

    String checkSourceNameAndlink(TDbSource param);

    TDbSource selectSourceByID(TDbSource param);

    int deleteDBSourceByID(TDbSource param);

    List<LdgTableInfo> getTableInfo(TDbSource param, String tableName);
}
