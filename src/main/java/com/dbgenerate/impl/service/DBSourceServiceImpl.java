package com.dbgenerate.impl.service;

import com.dbgenerate.api.bo.LdgTable;
import com.dbgenerate.api.bo.LdgTableInfo;
import com.dbgenerate.api.service.DBSourceService;
import com.dbgenerate.api.po.TDbSource;
import com.dbgenerate.api.utils.DbInfoUtil;
import com.dbgenerate.impl.mapper.TDbSourceMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldg.api.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;

/**
 * Created by LiuDongguang on 2017/7/7.
 */
@Service
public class DBSourceServiceImpl implements DBSourceService {
    @Autowired
    private TDbSourceMapper tDbSourceMapper;

    @Override
    public PageInfo<TDbSource> getDbsourceList(PageParam pageParam) {
        PageInfo<TDbSource> pageInfo = PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true).doSelectPageInfo(() -> tDbSourceMapper.selectAllForTimeOrder());
        return pageInfo;
    }

    @Override
    public int saveSource(TDbSource param) {
        if (param.getUid() == null) {
            param.setCreatetime(new Date());
        } else {
            return tDbSourceMapper.updateByPrimaryKeySelective(param);
        }
        return tDbSourceMapper.insertSelective(param);
    }

    @Override
    public List<LdgTable> getTables(TDbSource param) throws Exception {
        List<LdgTable> tablelist=DbInfoUtil.getTableList(param);
        return tablelist;
    }

    @Override
    public String checkSourceNameAndlink(TDbSource param) {
        Integer uid = tDbSourceMapper.selectUIDBySourceName(param);
        if (uid != null) {
            return "重复的数据源名！";
        } else {
            uid = tDbSourceMapper.selectUIDBySourceLink(param);
            if (uid != null) {
                return "重复的连接地址！";
            }
        }

        return null;
    }

    @Override
    public TDbSource selectSourceByID(TDbSource param) {
        return tDbSourceMapper.selectByPrimaryKey(param.getUid());
    }

    @Override
    public int deleteDBSourceByID(TDbSource param) {
        return tDbSourceMapper.deleteByPrimaryKey(param.getUid());
    }

    @Override
    public List<LdgTableInfo> getTableInfo(TDbSource param, String tableName) {
        return DbInfoUtil.getTableInfo(param,tableName);
    }
}
